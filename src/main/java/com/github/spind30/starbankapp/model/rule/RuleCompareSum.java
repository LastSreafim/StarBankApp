package com.github.spind30.starbankapp.model.rule;

import com.github.spind30.starbankapp.model.Rule;
import com.github.spind30.starbankapp.model.enums.BankProductType;
import com.github.spind30.starbankapp.model.enums.CompareType;
import com.github.spind30.starbankapp.model.enums.OperationType;

public class RuleCompareSum extends RuleArguments implements Rule {

    private BankProductType productType;
    private OperationType operationType;
    private CompareType compareType;
    private int amount;

    @Override
    public String getSubQuery() {
        return "";
    }
}
