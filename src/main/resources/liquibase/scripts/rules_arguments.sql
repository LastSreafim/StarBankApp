-- liquibase formatted sql

--changeset antonio.brightside:1
CREATE EXTENSION IF NOT EXISTS "pgcrypto"; --для подключения функции генерации UUID

CREATE TABLE rules_arguments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    rule_id  UUID REFERENCES rules (rule_id) ON DELETE CASCADE,
    argument VARCHAR NOT NULL
);