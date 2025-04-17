package com.github.spind30.starbankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Recommendation {
    private String name;
    private UUID id;
    private String text;
}