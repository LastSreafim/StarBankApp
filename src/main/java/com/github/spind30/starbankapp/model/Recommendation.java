package com.github.spind30.starbankapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "recommendations")
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID product_id;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String product_text;

}