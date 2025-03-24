package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.model.enums.CompareType;
import com.github.spind30.starbankapp.model.enums.ProductType;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TransactionSumCompareDepositWithdrawQuery extends AbstractQuery {

    @Autowired
    public TransactionSumCompareDepositWithdrawQuery() {
        super();
    }

    @Override
    protected boolean performInternal(UUID userId, RecommendationsRepository repo, List<String> arguments) {
        // Получаем аргументы
        ProductType productType = ProductType.fromString(arguments.get(0)); // Тип продукта, например "DEBIT"
        CompareType compareType = CompareType.fromString(arguments.get(2));

        // Получаем сумму транзакций с типом DEPOSIT и WITHDRAW для указанного продукта
        long depositSum = repo.getTransactionAmount(userId, productType.name(), "DEPOSIT");
        long withdrawSum = repo.getTransactionAmount(userId, productType.name(), "WITHDRAW");

        // Выполняем операцию сравнения
        return switch (compareType) {
            case LT -> depositSum < withdrawSum;
            case GT -> depositSum > withdrawSum;
            case EQ -> depositSum == withdrawSum;
            case LE -> depositSum <= withdrawSum;
            case GE -> depositSum >= withdrawSum;
            default -> throw new IllegalArgumentException("Unsupported compare type: " + compareType);
        };
    }
}
