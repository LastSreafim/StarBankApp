package com.github.spind30.starbankapp.model.queries;

import com.github.spind30.starbankapp.model.enums.BankProductType;
import com.github.spind30.starbankapp.model.enums.CompareType;
import com.github.spind30.starbankapp.model.enums.OperationType;

public class RuleCompareSum extends RuleArguments {

    private BankProductType productType;
    private OperationType operationType;
    private CompareType compareType;
    private long amount;

}
