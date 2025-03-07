package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.model.Rule;
import org.springframework.stereotype.Component;

@Component
public class HasSavingDepositGreaterThan1000 implements Rule {
    @Override
    public String getSubQuery() {
        return "";
    }
}
