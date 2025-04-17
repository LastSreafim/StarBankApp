package com.github.spind30.starbankapp.controllers;

import com.github.spind30.starbankapp.dto.Recommendation;
import com.github.spind30.starbankapp.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Recommendation>> getRecommendations(@PathVariable UUID userId) {
        return ResponseEntity.ok(recommendationService.getRecommendations(userId));
    }

}
