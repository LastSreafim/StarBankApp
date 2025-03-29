package com.github.spind30.starbankapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.spind30.starbankapp.model.rule.DynamicRule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class DynamicRuleDTO {

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_id")
    private UUID productId;

    @JsonProperty("product_text")
    private String productText;

    @JsonProperty("rule")
    private Set<QueryDTO> rule;

    public static DynamicRuleDTO fromEntity(DynamicRule rule) {
        return new DynamicRuleDTO(
                rule.getProductName(),
                rule.getProductId(),
                rule.getProductText(),
                rule.getRule().stream().map(QueryDTO::fromEntity).collect(Collectors.toSet())
        );
    }

    public DynamicRule toEntity() {
        DynamicRule dynamicRule = new DynamicRule();
        dynamicRule.setProductName(this.productName);
        dynamicRule.setProductId(this.productId);
        dynamicRule.setProductText(this.productText);
        dynamicRule.setRule(this.rule.stream().map(QueryDTO::toEntity).collect(Collectors.toSet())); // Преобразуем QueryDTO в Query
        return dynamicRule;
    }

}

