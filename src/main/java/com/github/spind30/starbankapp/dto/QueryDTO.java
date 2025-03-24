package com.github.spind30.starbankapp.dto;

import com.github.spind30.starbankapp.model.enums.QueryType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QueryDTO {
    private QueryType queryType;
    private boolean negates;
    private List<String> arguments;
}
