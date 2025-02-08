package ruleset;

import com.github.spind30.starbankapp.dto.RecommendationDTO;

import java.util.Optional;
import java.util.UUID;

public interface RecommendationRuleSet {
    Optional<RecommendationDTO> getRecommendation(UUID userId);
}
