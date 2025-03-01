package com.github.spind30.starbankapp.controllers;

import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.services.RuleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rule")
@AllArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @PostMapping
    public ResponseEntity<Recommendation> createRule(@RequestBody Recommendation recommendation) {
        ruleService.createRule(recommendation);
        return ResponseEntity.ok().build();
    }

}
