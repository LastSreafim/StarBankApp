package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public abstract class AbstractQuery {
    protected final boolean negate;
    protected final RecommendationsRepository recommendationRepo;

    @Autowired
    protected AbstractQuery(RecommendationsRepository recommendationRepo, boolean negate) {
        this.recommendationRepo = recommendationRepo;
        this.negate = negate;
    }

    public boolean perform(UUID userId, List<String> arguments) {
        boolean result = performInternal(userId, recommendationRepo, arguments);
        return negate ? !result : result;
    }


    protected abstract boolean performInternal(UUID userId, RecommendationsRepository repo,
                                               List<String> arguments);
}


