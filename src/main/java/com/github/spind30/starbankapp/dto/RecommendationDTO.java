package com.github.spind30.starbankapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.spind30.starbankapp.model.Recommendation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class RecommendationDTO {
    @JsonProperty("user_id")
    UUID userId;
    List<Recommendation> recommendations = new ArrayList<>();
}
