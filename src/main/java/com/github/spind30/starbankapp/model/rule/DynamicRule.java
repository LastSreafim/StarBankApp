package com.github.spind30.starbankapp.model.rule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.model.queries.Query;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dynamic_rules")
@ToString(exclude = "rule")
@EqualsAndHashCode(exclude = "rule")
public class DynamicRule {

    @JsonProperty("product_name")
    private String productName;
    @Id
    @JsonProperty("product_id")
    private UUID productId;
    @JsonProperty("product_text")
    private String productText;

    @OneToMany(mappedBy = "dynamicRule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Query> rule;

    public Recommendation toRecommendation() {
        return new Recommendation(productName, productId, productText);
    }
}




