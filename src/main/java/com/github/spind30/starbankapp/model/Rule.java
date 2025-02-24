package com.github.spind30.starbankapp.model;

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
    @JoinColumn(name="product_id")
    private Recommendation recommendation;

    private String query;

    //@ElementCollection
    //@CollectionTable(name = "rules_arguments", joinColumns = @JoinColumn(name="rule"))
    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL)
    private List<Argument> arguments;
    private boolean negate;
}
