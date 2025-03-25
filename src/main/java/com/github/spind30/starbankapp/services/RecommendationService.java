package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.components.AbstractQuery;
import com.github.spind30.starbankapp.components.QueryFactory;
import com.github.spind30.starbankapp.dto.DynamicRuleDTO;
import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.model.queries.Query;
import com.github.spind30.starbankapp.model.rule.DynamicRule;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import com.github.spind30.starbankapp.repository.RuleRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ruleset.RecommendationRuleSet;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecommendationService {

    List<RecommendationRuleSet> recommendationRules;

    private static final Logger logger = LoggerFactory.getLogger(RecommendationService.class);

    private final RecommendationsRepository recommendationsRepository;

    private final RuleRepository ruleRepository;

    private final DynamicRuleDTO rule;

    private final QueryFactory queryFactory;


    public List<Recommendation> getRecommendations(UUID userId) {
        return ruleRepository.findAll()
                .stream()
                .filter(it -> process(it, userId))
                .map(DynamicRule::toRecommendation)
                .collect(Collectors.toList());
    }


    public boolean process(DynamicRule rule, UUID userId) {
        return rule.getRules().stream()
                .map(query -> {
                    AbstractQuery abstractQuery = QueryFactory.from(query.getQueryType(), query.getArguments(), query.isNegate());
                    return abstractQuery.perform(userId, query.getArguments());
                })
                .reduce((a, b) -> a && b)
                .orElse(false);
    }


}
