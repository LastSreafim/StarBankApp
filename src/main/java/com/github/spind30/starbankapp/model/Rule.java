package com.github.spind30.starbankapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rules")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID rule_id;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "product_id")
    private Recommendation recommendation;

    private String query;

    @ElementCollection
    @CollectionTable(name = "rules_arguments", joinColumns = @JoinColumn(name="rule_id"))
    private List<String> arguments;
    private boolean negate;
}
