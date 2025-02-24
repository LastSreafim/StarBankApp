package com.github.spind30.starbankapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "recommendations")
public class Recommendation { // TODO: Возможно стоит переписать как RecommendationRequest и сделать RecommendationResponse с добавлением сгенерированного ID. Хотя странно выглядит ради добавления одного ID
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID product_id;
    @JsonProperty("product_name")
    private String name;
    @JsonProperty("product_text")
    private String text;

    @OneToMany(mappedBy = "recommendation", cascade = CascadeType.ALL)
    private List<Rule> rule;
}
