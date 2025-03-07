package com.github.spind30.starbankapp.model.rule;

import com.github.spind30.starbankapp.model.Product;
import com.github.spind30.starbankapp.model.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicRule implements Product {

    private UUID productId;
    private String productName;
    private String productText;
    private Set<Rule> rules;


    @Override
    public String getQuery() {
        return "";
    }
}
