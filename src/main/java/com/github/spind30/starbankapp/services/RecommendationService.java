package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.components.AbstractQuery;
import com.github.spind30.starbankapp.components.QueryFactory;
import com.github.spind30.starbankapp.dto.DynamicRuleDTO;
import com.github.spind30.starbankapp.dto.Recommendation;
import com.github.spind30.starbankapp.model.enums.QueryType;
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

        List<DynamicRuleDTO> rules = ruleRepository.findAll()
                .stream()
                .map(DynamicRuleDTO::fromEntity)
                .toList();

        return rules.stream()
                .filter(ruleDTO -> process(ruleDTO, userId))
                .map(this::toRecommendation)
                .collect(Collectors.toList());
    }


    public boolean process(DynamicRuleDTO ruleDTO, UUID userId) {
        return ruleDTO.getRule().stream()
                .map(queryDTO -> {
                    // Здесь вам нужно создать AbstractQuery и выполнить проверку на основании QueryDTO
                    AbstractQuery abstractQuery = QueryFactory.from(QueryType.valueOf(queryDTO.getQuery()), queryDTO.getArguments(), queryDTO.isNegate());
                    return abstractQuery.perform(userId, queryDTO.getArguments());
                })
                .reduce((a, b) -> a && b)
                .orElse(false);
    }


    public Recommendation toRecommendation(DynamicRuleDTO ruleDTO) {
        return new Recommendation(ruleDTO.getProductName(), ruleDTO.getProductId(), ruleDTO.getProductText());
    }
}

