package com.github.spind30.starbankapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.spind30.starbankapp.model.enums.QueryType;
import com.github.spind30.starbankapp.model.queries.Query;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryDTO {

    @JsonProperty("query")
    private String query;

    @JsonProperty("arguments")
    private List<String> arguments;

    @JsonProperty("negate")
    private boolean negate;

    public static QueryDTO fromEntity(Query query) {
        return new QueryDTO(
                query.getQueryType().name(), // Предполагаю, что queryType — это Enum
                query.getArguments(),
                query.isNegate()
        );
    }

    public Query toEntity() {
        Query query = new Query();
        query.setQueryType(QueryType.valueOf(this.query));
        query.setArguments(this.arguments);
        query.setNegate(this.negate);
        return query;
    }

}

