package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.model.Rule;
import com.github.spind30.starbankapp.repository.RuleRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RuleService {
    private final Logger logger = LoggerFactory.getLogger(RuleService.class);
    private final RuleRepository ruleRepository;

    public void createRule(Recommendation recommendation) {
        logger.info("Сохраняем новое правило");
        ruleRepository.save(recommendation);
        logger.info("Правило сохранено в базу");
    }
}
