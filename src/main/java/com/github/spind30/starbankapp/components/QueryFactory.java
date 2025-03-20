package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.model.enums.QueryType;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class QueryFactory {


    @Autowired
    private RecommendationsRepository recommendationRepo;

    public AbstractQuery createQuery(QueryType queryType, boolean negate, List<String> arguments) {
        switch (queryType) {
            case USER_OF:
                return new UserOfQuery(recommendationRepo, negate);
            case ACTIVE_USER_OF:
                return new ActiveUserOfQuery(recommendationRepo, negate);
            case TRANSACTION_SUM_COMPARE:
                return new TransactionSumCompareQuery(recommendationRepo,
                        negate);
            case TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW:
                return new TransactionSumCompareDepositWithdrawQuery(recommendationRepo,
                        negate);
            default:
                throw new IllegalArgumentException("Unsupported query type: " + queryType);
        }
    }
}


