package com.github.spind30.starbankapp.dto;

import com.github.spind30.starbankapp.model.enums.QueryType;
import com.github.spind30.starbankapp.model.queries.RuleArguments;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueryDTO {
    private int id;
    private QueryType queryType;
    private boolean negates;
    private RuleArguments arguments;
}
