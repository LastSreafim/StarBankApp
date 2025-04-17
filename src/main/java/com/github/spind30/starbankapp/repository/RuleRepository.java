package com.github.spind30.starbankapp.repository;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.spind30.starbankapp.model.rule.DynamicRule;
import com.github.spind30.starbankapp.model.rulestat.RuleStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Repository
public interface RuleRepository extends JpaRepository<DynamicRule, UUID> {


    Cache<String, Integer> ruleTriggerCountCache = Caffeine.newBuilder()
            .expireAfterWrite(1, TimeUnit.HOURS)
            .maximumSize(100)
            .build();

    default void incrementRuleTriggerCount(UUID ruleId) {
        String cacheKey = ruleId.toString();
        Integer currentValue = ruleTriggerCountCache.getIfPresent(cacheKey);
        ruleTriggerCountCache.put(cacheKey, currentValue != null ? currentValue + 1 : 1);
    }


    default List<RuleStat> getRuleStats() {
        List<DynamicRule> allRules = findAll();
        return allRules.stream()
                .map(rule -> {
                    String cacheKey = rule.getProductId().toString();
                    Integer triggerCount = ruleTriggerCountCache.getIfPresent(cacheKey);
                    return new RuleStat(rule.getProductId(), triggerCount != null ? triggerCount : 0);
                })
                .toList();
    }


    default void clearCache() {
        ruleTriggerCountCache.invalidateAll();
    }
}
