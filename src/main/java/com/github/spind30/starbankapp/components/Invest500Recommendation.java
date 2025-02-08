package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.dto.RecommendationDTO;
import org.springframework.stereotype.Component;
import ruleset.RecommendationRuleSet;

import java.util.Optional;
import java.util.UUID;

@Component
public class Invest500Recommendation implements RecommendationRuleSet {

    @Override
    public Optional<RecommendationDTO> getRecommendation(UUID userId) {
        return Optional.empty();
    }
}
