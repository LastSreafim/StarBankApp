package com.github.spind30.starbankapp.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Генерирует геттеры, сеттеры, toString, equals, hashCode
@AllArgsConstructor // Создает конструктор со всеми аргументами
@NoArgsConstructor  // Создает пустой конструктор
public class RecommendationDTO {
    private UUID id;
    private String name;
    private String text;
}
