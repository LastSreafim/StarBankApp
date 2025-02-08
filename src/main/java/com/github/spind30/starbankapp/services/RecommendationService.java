package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.dto.RecommendationDTO;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ruleset.RecommendationRuleSet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RecommendationService {

    List <RecommendationRuleSet> recommendationRules;

    private static final Logger logger = LoggerFactory.getLogger(RecommendationService.class);

    private final RecommendationsRepository recommendationsRepository;

    public List<RecommendationDTO> getRecommendations(UUID userId) {
        logger.info("Получаем рекомендации для пользователя {}", userId);
        List<RecommendationDTO> recommendations = new ArrayList<>();
        for (RecommendationRuleSet rule : recommendationRules) {
            rule.getRecommendation(userId)
                    .ifPresent(recommendations::add);
        }
        logger.info("Найдено {} рекомендаций", recommendations.size());
        return recommendations;
    }

}
