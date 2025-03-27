package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public abstract class AbstractQuery {

    protected final RecommendationsRepository recommendationRepo;
    @Setter
    protected boolean negate;

    public AbstractQuery(RecommendationsRepository recommendationRepo) {
        this.recommendationRepo = recommendationRepo;
    }

    public boolean perform(UUID userId, List<String> arguments) {
        boolean result = performInternal(userId, recommendationRepo, arguments);
        return negate ? !result : result;
    }

    protected abstract boolean performInternal(UUID userId, RecommendationsRepository repo, List<String> arguments);
}





