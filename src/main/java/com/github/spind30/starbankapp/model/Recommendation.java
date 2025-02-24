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
@Entity(name = "recommendations")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID product_id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_text")
    private String text;

    @OneToMany(mappedBy = "recommendation", cascade = CascadeType.ALL)
    private List<Rule> rule;
}
