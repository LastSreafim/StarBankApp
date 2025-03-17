package com.github.spind30.starbankapp.model.queries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.spind30.starbankapp.model.enums.QueryType;
import com.github.spind30.starbankapp.model.rule.DynamicRule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "queries")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Enumerated(EnumType.STRING)
    private QueryType queryType;

    @ManyToMany
    @JoinTable(
            name = "query_arguments",
            joinColumns = @JoinColumn(name = "query_id"),
            inverseJoinColumns = @JoinColumn(name = "argument_id")
    )
    private List<RuleArguments> arguments;

    @ManyToMany(mappedBy = "rules")
    private List<DynamicRule> dynamicRules;

    private boolean negate;
}

