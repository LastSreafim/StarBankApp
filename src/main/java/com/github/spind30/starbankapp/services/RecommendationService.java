package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.components.AbstractQuery;
import com.github.spind30.starbankapp.components.QueryFactory;
import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.model.queries.Query;
import com.github.spind30.starbankapp.model.rule.DynamicRule;
import com.github.spind30.starbankapp.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecommendationService {

    private final RuleRepository ruleRepository;

    public List<Recommendation> getRecommendations(UUID userId) {
        List <DynamicRule> rules = ruleRepository.findAll();
        return ruleRepository.findAll()
                .stream()
                .filter(it -> process(it, userId))
                .map(DynamicRule::toRecommendation)
                .collect(Collectors.toList());
    }


    public boolean process(DynamicRule rule, UUID userId) {
        Set<Query> queries = rule.getRule();
        return rule.getRule().stream()
                .map(query -> {
                    AbstractQuery abstractQuery = QueryFactory.from(query.getQueryType(), query.getArguments(), query.isNegate());
                    return abstractQuery.perform(userId, query.getArguments());
                })
                .reduce((a, b) -> a && b)
                .orElse(false);
    }


}
