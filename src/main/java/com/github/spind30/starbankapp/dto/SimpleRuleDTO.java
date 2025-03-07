package com.github.spind30.starbankapp.dto;

import com.github.spind30.starbankapp.model.enums.QueryType;
import com.github.spind30.starbankapp.model.rule.RuleArguments;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleRuleDTO {
    private int id;
    private QueryType queryType;
    private boolean negates;
    private RuleArguments arguments;
}
