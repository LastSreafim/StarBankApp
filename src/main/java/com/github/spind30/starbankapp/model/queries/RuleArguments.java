package com.github.spind30.starbankapp.model.queries;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
/*
 * Определяет стратегию наследования для классов-потомков.
 *
 * JOINED - это стратегия, при которой для каждого дочернего класса создается отдельная таблица.
 * - Общее поле (`id`) хранится в таблице `rule_arguments`.
 * - Уникальные поля подклассов (`productType`, `count` и т. д.) хранятся в отдельных таблицах.
 * - Дочерние таблицы содержат внешний ключ (`id`), который ссылается на `rule_arguments.id`.
 *
 * Преимущества:
 * - Экономия места: дублирование данных минимально.
 * - Гибкость: можно добавлять новые подклассы без изменения основной таблицы.
 *
 * Недостатки:
 * - Производительность: для загрузки дочернего объекта требуется `JOIN`-запрос между таблицами.
 */
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
/*
 * Добавляет в таблицу `rule_arguments` колонку `type`, которая определяет, к какому классу-потомку относится запись.
 *
 * Например:
 * - Если строка `type = "RULE_ACTIVE_USER_OF"`, то эта запись относится к классу `RuleActiveUserOf`.
 */
@Table(name = "rule_arguments")
public abstract class RuleArguments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToMany(mappedBy = "arguments")
    private List<Query> queries;
}


