package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;
import ruleset.RecommendationRuleSet;

import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;

//Создаём компонент интерфейса для рекомендации Invest500
@Component
@AllArgsConstructor // Генерирует конструктор с параметрами для всех полей
public class Invest500Recommendation implements RecommendationRuleSet {
    private final RecommendationsRepository recommendationsRepository;

    @Override
    public Optional<Recommendation> getRecommendation(UUID userId) {
        int countDebit = recommendationsRepository.getTransactionCount(userId, "DEBIT");
        int countInvest = recommendationsRepository.getTransactionCount(userId, "INVEST");
        long sumDepositSaving = recommendationsRepository.getTransactionAmount(userId, "SAVING", "DEPOSIT");
        if (countDebit > 0 & countInvest == 0 & sumDepositSaving > 1000) {
            return Optional.of(new Recommendation(
                    "Invest500",
                    UUID.fromString("147f6a0f-3b91-413b-ab99-87f081d60d5a"),
                    "Откройте свой путь к успеху с " +
                            "индивидуальным инвестиционным счетом (ИИС) от нашего банка! " +
                            "Воспользуйтесь налоговыми льготами и начните инвестировать с умом. " +
                            "Пополните счет до конца года и получите выгоду в виде вычета на взнос " +
                            "в следующем налоговом периоде. Не упустите возможность разнообразить " +
                            "свой портфель, снизить риски и следить за актуальными рыночными тенденциями. " +
                            "Откройте ИИС сегодня и станьте ближе к финансовой независимости!"
            ));
        }
        return Optional.empty();
    }
}

