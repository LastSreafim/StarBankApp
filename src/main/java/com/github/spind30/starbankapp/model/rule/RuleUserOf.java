package com.github.spind30.starbankapp.model.rule;

import com.github.spind30.starbankapp.model.Rule;
import com.github.spind30.starbankapp.model.enums.BankProductType;

public class RuleUserOf extends RuleArguments implements Rule {

   private BankProductType productType;

    @Override
    public String getSubQuery() {
        return "";
    }
}
