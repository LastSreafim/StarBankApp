package com.github.spind30.starbankapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRecommendationDTO {
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_id")
    private UUID productId;
    @JsonProperty("product_text")
    private String productText;
    //TODO: добавить List of Rules
}
