package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.model.rule.DynamicRule;
import com.github.spind30.starbankapp.repository.RuleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RuleService {

    private final Logger logger = LoggerFactory.getLogger(RuleService.class);

    @Autowired
    private final RuleRepository ruleRepository;

    @Transactional
    public DynamicRule createRule(DynamicRule dynamicRule) {
        if (dynamicRule.getRule() != null) {
            dynamicRule.getRule().forEach(query -> query.setDynamicRule(dynamicRule));
        }
        logger.info("Правило сохранено");
        return ruleRepository.save(dynamicRule);
    }


    public void deleteRule(UUID id) {
        ruleRepository.deleteById(id);
    }

    public DynamicRule editRule(DynamicRule dynamicRule) {
       return ruleRepository.save(dynamicRule);
    }

    public List<DynamicRule> getAllRules() {
        return ruleRepository.findAll();
    }


}
