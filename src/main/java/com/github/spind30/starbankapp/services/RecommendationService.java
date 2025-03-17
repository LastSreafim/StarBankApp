package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.dto.DynamicRuleDTO;
import com.github.spind30.starbankapp.dto.RecommendationDTO;
import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.model.rule.DynamicRule;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ruleset.RecommendationRuleSet;

import java.util.*;

@Service
@AllArgsConstructor
public class RecommendationService {

    List <RecommendationRuleSet> recommendationRules;

    private static final Logger logger = LoggerFactory.getLogger(RecommendationService.class);

    private final RecommendationsRepository recommendationsRepository;

    public DynamicRuleDTO getRecommendations(UUID userId) {
        List<DynamicRule> recommendations = new ArrayList<>();
        for (RecommendationRuleSet rule : recommendationRules) {
            rule.getRecommendation(userId)
                    .ifPresent(recommendations::add);
        }
        logger.info("Найдено {} рекомендаций", recommendations.size());

        return new DynamicRuleDTO(userId, recommendations);
    }


}
