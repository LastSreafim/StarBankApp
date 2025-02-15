package com.github.spind30.starbankapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*
!!!Класс является тестовым, пока предлагаю оставить для опоры.

Данный код является примером и позволяет понять, каким образом можно работать с
JdbcTemplate
 */
@Repository
public class RecommendationsRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecommendationsRepository(@Qualifier("recommendationsJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Создаём метод получения количества транзакций
    public int getTransactionCount(UUID userId, String productType) {
        Integer result = jdbcTemplate.queryForObject(
                "SELECT COUNT(t.AMOUNT) " +
                        "FROM transactions t " +
                        "JOIN products p ON t.product_id = p.id " +
                        "WHERE t.user_id = ? " + // добавляем параметр для id пользователя
                        "  AND p.type = ?;", // добавляем параметр для тип продукта
                Integer.class,
                userId,  // первый параметр — userId
                productType);  // второй параметр — productType
        return result != null ? result : 0;
    }

    // Создаём метод получения суммы по транзакциям в продукте определённого типа
    public long getTransactionAmount(UUID userId, String productType, String transactionType) {
        Long result = jdbcTemplate.queryForObject(
                "SELECT SUM(t.AMOUNT) " +
                        "FROM transactions t " +
                        "JOIN products p ON t.product_id = p.id " +
                        "WHERE t.user_id = ? " +  // добавляем параметр для id пользователя
                        "AND p.type = ? " +  // добавляем параметр для типа продукта
                        "AND t.type = ?;",  // фильтрация по типу транзакции
                Long.class,
                userId,  // первый параметр — userId
                productType, // второй параметр — productType
                transactionType); // третий параметр — transactionType
        return result != null ? result : 0L;
    }

}
