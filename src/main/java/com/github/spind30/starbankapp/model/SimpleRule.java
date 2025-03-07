package com.github.spind30.starbankapp.model;

import com.github.spind30.starbankapp.model.enums.QueryType;
import com.github.spind30.starbankapp.model.rule.RuleArguments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleRule implements Rule {


    private Integer id;
    private QueryType queryType;
    private boolean negate;
    private RuleArguments arguments;

    @Override
    public String getSubQuery() {
        return "";
    }
}
