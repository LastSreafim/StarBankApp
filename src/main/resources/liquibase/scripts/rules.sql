-- liquibase formatted sql

--changeset antonio.brightside:1
CREATE EXTENSION IF NOT EXISTS "pgcrypto"; --для подключения функции рандомизации UUID

CREATE TABLE rules (
    rule_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_id UUID REFERENCES recommendations(product_id) ON DELETE CASCADE,
    query VARCHAR NOT NULL,
    arguments VARCHAR[] NOT NULL,
    negate BOOLEAN NOT NULL
);