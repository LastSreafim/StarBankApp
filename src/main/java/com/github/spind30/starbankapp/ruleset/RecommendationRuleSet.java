package com.github.spind30.starbankapp.ruleset;


import com.github.spind30.starbankapp.dto.Recommendation;

import java.util.Optional;
import java.util.UUID;

public interface RecommendationRuleSet {
    Optional<Recommendation> getRecommendation(UUID userId);
}
