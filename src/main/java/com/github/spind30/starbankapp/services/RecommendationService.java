package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.dto.RecommendationDTO;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
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

    List <RecommendationRuleSet> recommendationRules;

    private static final Logger logger = LoggerFactory.getLogger(RecommendationService.class);

    private final RecommendationsRepository recommendationsRepository;

    //Здесь оставлю код, который был до этого для ознакомления,
    // , полезно увидеть разницу и потестировать в случае надобности

//    public List<RecommendationDTO> getRecommendations(UUID userId) {
//        logger.info("Получаем рекомендации для пользователя {}", userId);
//        List<RecommendationDTO> recommendations = new ArrayList<>();
//        for (RecommendationRuleSet rule : recommendationRules) {
//            rule.getRecommendation(userId)
//                    .ifPresent(recommendations::add);
//        }
//        logger.info("Найдено {} рекомендаций", recommendations.size());
//        return recommendations;
//    }

    public Map<String, Object> getRecommendations(UUID userId) {
        List<RecommendationDTO> recommendations = new ArrayList<>();
        for (RecommendationRuleSet rule : recommendationRules) {
            rule.getRecommendation(userId)
                    .ifPresent(recommendations::add);
        }
        logger.info("Найдено {} рекомендаций", recommendations.size());
        Map<String, Object> result = new LinkedHashMap<>(); // Использую LinkedHashMap, чтобы упорядочить ключи в мапе
        result.put("user_id", userId);
        result.put("recommendations", recommendations);

        return result;
    }


}
