package com.github.spind30.starbankapp.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.spind30.starbankapp.literals.Literals;
import com.github.spind30.starbankapp.model.Rule;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Component
public class Invest500Product implements Product {
    @Getter
    private final String id = "147f6a0f-3b91-413b-ab99-87f081d60d5a";
    @Getter
    private final String name = "Invest 500";

    private final Set<Rule> rules = new HashSet<>();

    public Invest500Product(@Qualifier("hasDebitTypeProduct") Rule rule1,
                            @Qualifier("hasNotInvestTypeProduct") Rule rule2,
                            @Qualifier("hasSavingDepositGreaterThan1000") Rule rule3) {
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
    }

    @JsonIgnore
    @Override
    public String getQuery() {
        StringJoiner joiner = new StringJoiner(" AND ", Literals.QUERY_PREFIX, Literals.QUERY_SUFFIX);

        rules.forEach(rule -> joiner.add(rule.getSubQuery()));

        return joiner.toString();
    }
}
