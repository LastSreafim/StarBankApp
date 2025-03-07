package com.github.spind30.starbankapp.model.rule;

import com.github.spind30.starbankapp.model.Rule;
import com.github.spind30.starbankapp.model.enums.BankProductType;
import com.github.spind30.starbankapp.model.enums.CompareType;

public class RuleCompareOperationSum extends RuleArguments implements Rule {

    private BankProductType productType;
    private CompareType compareType;

    @Override
    public String getSubQuery() {
        return "";
    }
}
