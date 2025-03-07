package com.github.spind30.starbankapp.services;

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
    public Rule createRule(Rule rule) {
        logger.info("Правило сохранено");
        return ruleRepository.save(rule);
    }

    public void deleteRule(UUID id) {
        ruleRepository.deleteById(id);
    }

    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    // Проверка выполнения правила для пользователя
    public boolean checkRuleForUser(UUID userId, Rule rule) {
        // Реализация проверки выполнения правила (логика зависит от типа запроса)
        // Здесь можно использовать SQL-запросы или другие механизмы для проверки условий
        return true; // Placeholder для демонстрации
    }
}
