package com.github.spind30.starbankapp.controllers;

import com.github.spind30.starbankapp.dto.DynamicRuleDTO;
import com.github.spind30.starbankapp.dto.RuleStatDTO;
import com.github.spind30.starbankapp.services.RuleService;
import com.github.spind30.starbankapp.services.RuleStatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/rule")
@AllArgsConstructor
public class RuleController {
    private final RuleStatService ruleStatService;
    private final RuleService ruleService;

    @PostMapping
    public ResponseEntity<DynamicRuleDTO> createRule(@RequestBody DynamicRuleDTO ruleDTO) {
        DynamicRuleDTO createdRule = ruleService.createRule(ruleDTO);
        return ResponseEntity.ok(createdRule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable UUID id) {
        ruleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Map<String, List<DynamicRuleDTO>>> getAllRules() {
        List<DynamicRuleDTO> rules = ruleService.getAllRules();
        return ResponseEntity.ok(Map.of("data", rules));
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, List<RuleStatDTO>>> getStats() {
        List<RuleStatDTO> stats = ruleStatService.getAllStats();
        Map<String, List<RuleStatDTO>> response = new HashMap<>();
        response.put("stats", stats);
        return ResponseEntity.ok(response);
    }

}

