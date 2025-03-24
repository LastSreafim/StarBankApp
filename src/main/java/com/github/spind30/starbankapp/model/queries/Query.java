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

    private List<String> arguments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dynamic_rule_id")
    @JsonIgnore
    private DynamicRule dynamicRule;

    private boolean negate;
}

