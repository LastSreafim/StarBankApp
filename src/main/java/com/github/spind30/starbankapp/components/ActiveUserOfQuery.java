package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.model.enums.ProductType;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ActiveUserOfQuery extends AbstractQuery {

    @Autowired
    public ActiveUserOfQuery(RecommendationsRepository recommendationsRepository) {
        super(recommendationsRepository);
    }

    @Override
    protected boolean performInternal(UUID userId, RecommendationsRepository repo, List<String> arguments) {
        ProductType productType = ProductType.fromString(arguments.getFirst());
        return repo.getTransactionCount(userId, productType.name()) >= 5;
    }
}
