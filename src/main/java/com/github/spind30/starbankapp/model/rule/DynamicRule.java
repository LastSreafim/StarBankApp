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


    @OneToMany(mappedBy = "dynamicRule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Query> rules;
}
