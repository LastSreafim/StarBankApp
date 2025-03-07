package com.github.spind30.starbankapp.components;

import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import com.github.spind30.starbankapp.model.Recommendation;
import com.github.spind30.starbankapp.repository.RecommendationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ruleset.RecommendationRuleSet;

import java.util.Optional;
import java.util.UUID;

//Создаём компонент интерфейса для рекомендации Простой кредит
@Component
@AllArgsConstructor
public class SimpleCreditRecommendation implements RecommendationRuleSet {
    private final RecommendationsRepository recommendationsRepository;

    @Override
    public Optional<Recommendation> getRecommendation(UUID userId) { // Временная замена основному методу. Потом надо переписать
        return Optional.empty();
    }

////    @Override
////    public Optional<Recommendation> getRecommendation(UUID userId) {
////        int countCredit = recommendationsRepository.getTransactionCount(userId, "CREDIT");
////        long sumDepositDebit = recommendationsRepository.
////                getTransactionAmount(userId, "DEBIT", "DEPOSIT");
////        long sumWithdrawDebit = recommendationsRepository.
////                getTransactionAmount(userId, "DEBIT", "WITHDRAW");
////        if (countCredit == 0 & sumWithdrawDebit < sumDepositDebit & sumWithdrawDebit > 100_000) {
////            return Optional.of(new Recommendation(
////                    "Простой кредит",
////                    UUID.fromString("ab138afb-f3ba-4a93-b74f-0fcee86d447f"),
////                    "Откройте мир выгодных кредитов с нами!\n" +
////                            "\n" +
////                            "Ищете способ быстро и без лишних хлопот получить нужную сумму? " +
////                            "Тогда наш выгодный кредит — именно то, что вам нужно! " +
////                            "Мы предлагаем низкие процентные ставки, гибкие условия и " +
////                            "индивидуальный подход к каждому клиенту.\n" +
////                            "\n" +
////                            "Почему выбирают нас:\n" +
////                            "\n" +
////                            "Быстрое рассмотрение заявки. Мы ценим ваше время, поэтому процесс " +
////                            "рассмотрения заявки занимает всего несколько часов.\n" +
////                            "\n" +
////                            "Удобное оформление. Подать заявку на кредит можно онлайн " +
////                            "на нашем сайте или в мобильном приложении.\n" +
////                            "\n" +
////                            "Широкий выбор кредитных продуктов. Мы предлагаем кредиты на " +
////                            "различные цели: покупку недвижимости, автомобиля, образование, лечение и многое другое.\n" +
////                            "\n" +
////                            "Не упустите возможность воспользоваться выгодными " +
////                            "условиями кредитования от нашей компании!"
////            ));
////        }
////        return Optional.empty();
////    }
}
