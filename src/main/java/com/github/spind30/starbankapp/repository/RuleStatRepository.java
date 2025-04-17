package com.github.spind30.starbankapp.repository;

import com.github.spind30.starbankapp.model.rulestat.RuleStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RuleStatRepository extends JpaRepository<RuleStat, UUID> {

    Optional<RuleStat> findByRuleId(UUID ruleId);
}

