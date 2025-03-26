package com.github.spind30.starbankapp.controllers;

import com.github.spind30.starbankapp.model.rule.DynamicRule;
import com.github.spind30.starbankapp.services.RuleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rule")
@AllArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @PostMapping
    public ResponseEntity<DynamicRule> createRule(@RequestBody DynamicRule rule) {
        ruleService.createRule(rule);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable UUID id) {
        ruleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DynamicRule>> getAllRules() {
        List<DynamicRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }
}
