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

    public AbstractQuery from(QueryType queryType, List<String> arguments, boolean negate) {
        switch (queryType) {
            case USER_OF:
                return new UserOfQuery();
            case ACTIVE_USER_OF:
                return new ActiveUserOfQuery();
            case TRANSACTION_SUM_COMPARE:
                return new TransactionSumCompareQuery();
            case TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW:
                return new TransactionSumCompareDepositWithdrawQuery();
            default:
                throw new IllegalArgumentException("Unsupported query type: " + queryType);
        }
    }
}


