package com.github.spind30.starbankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class RuleStatDTO {
    private UUID ruleId;
    private int count;

}

