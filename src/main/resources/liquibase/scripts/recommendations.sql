-- liquibase formatted sql

--changeset antonio.brightside:1
CREATE EXTENSION IF NOT EXISTS "pgcrypto"; --для подключения функции генерации UUID

CREATE TABLE recommendations (
    product_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR NOT NULL,
    text VARCHAR NOT NULL
);