-- liquibase.sql

CREATE TABLE IF NOT EXISTS dynamic_rules (
    product_id UUID NOT NULL,
    product_name VARCHAR(255),
    product_text VARCHAR(255),
    CONSTRAINT dynamic_rules_pkey PRIMARY KEY (product_id)
);


CREATE INDEX IF NOT EXISTS idx_dynamic_rules_product_name ON dynamic_rules (product_name);


CREATE TABLE IF NOT EXISTS public.queries
(
    id SERIAL PRIMARY KEY,  -- Используем SERIAL для автоинкремента
    arguments character varying(255)[] COLLATE pg_catalog."default",  -- Массив строк с ограничением длины 255 символов
    negate boolean NOT NULL,  -- Столбец для флага negate
    query_type character varying(255) COLLATE pg_catalog."default",  -- Строка для типа запроса
    dynamic_rule_id uuid,  -- Внешний ключ на таблицу dynamic_rules
    CONSTRAINT fk_dynamic_rule FOREIGN KEY (dynamic_rule_id)
        REFERENCES public.dynamic_rules (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT query_type_check CHECK (query_type::text = ANY (ARRAY['USER_OF'::character varying, 'ACTIVE_USER_OF'::character varying, 'TRANSACTION_SUM_COMPARE'::character varying, 'TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW'::character varying]::text[]))
);

CREATE INDEX IF NOT EXISTS idx_queries_dynamic_rule_id ON public.queries (dynamic_rule_id);




