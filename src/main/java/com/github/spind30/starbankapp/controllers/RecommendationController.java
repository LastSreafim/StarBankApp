package com.github.spind30.starbankapp.controllers;

import com.github.spind30.starbankapp.dto.RecommendationDTO;
import com.github.spind30.starbankapp.services.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/recommendation")
@AllArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<RecommendationDTO>> getRecommendations(@PathVariable UUID userId) {
        List<RecommendationDTO> recommendations = recommendationService.getRecommendations(userId);
        return ResponseEntity.ok(recommendations);
    }

}
