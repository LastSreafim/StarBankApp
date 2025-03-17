package com.github.spind30.starbankapp.model.rule;

import com.github.spind30.starbankapp.model.queries.Query;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dynamic_rules")
public class DynamicRule {

    @Id
    private UUID productId;
    private String productName;
    private String productText;


    @ManyToMany
    @JoinTable(
            name = "dynamic_rule_query",  // Таблица для связи
            joinColumns = @JoinColumn(name = "dynamic_rule_id", referencedColumnName = "productId"),
            // Внешний ключ для dynamic_rule с указанием productId
            inverseJoinColumns = @JoinColumn(name = "query_id")
            // Внешний ключ для query
    )
    private Set<Query> rules;
}
