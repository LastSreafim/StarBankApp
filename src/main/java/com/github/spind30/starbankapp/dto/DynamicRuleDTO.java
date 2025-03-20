package com.github.spind30.starbankapp.dto;

import com.github.spind30.starbankapp.model.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DynamicRuleDTO {
    private UUID productId;
    private String productName;
    private String productText;
    private Set<QueryDTO> rules;
}
