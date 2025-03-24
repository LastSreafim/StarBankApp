package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.components.QueryFactory;
import com.github.spind30.starbankapp.dto.DynamicRuleDTO;
import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.model.rule.DynamicRule;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import com.github.spind30.starbankapp.repository.RuleRepository;
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

    private final RuleRepository ruleRepository;

    private final DynamicRuleDTO rule;

    private final QueryFactory queryFactory;

//    public RecommendationDTO getRecommendations(UUID userId) {
//        List<Recommendation> recommendations = new ArrayList<>();
//        for (RecommendationRuleSet rule : recommendationRules) {
//            rule.getRecommendation(userId)
//                    .ifPresent(recommendations::add);
//        }
//        logger.info("Найдено {} рекомендаций", recommendations.size());
//
//        return new RecommendationDTO(userId, recommendations);
//    }

    public Recommendation getRecommendations(UUID userId) {
        List<DynamicRule> rules = ruleRepository.findAll()
                .stream()
                .map(it -> process(it, userId))
                .collect() => List<Recommendation>

    }

    public boolean process(DynamicRule it, UUID userId) {
        return rule.getQueries()
                .map(QueryFactory::from)  // Создаём Query-объекты
                .map(it -> it.perform(...))  // Выполняем запросы
        .reduce((a, b) -> a && b)  // Объединяем результаты
                .orElse(false);  // Если список пуст, вернуть false
    }




}
