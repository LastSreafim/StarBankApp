-- liquibase formatted sql

--changeset antonio.brightside:1
CREATE EXTENSION IF NOT EXISTS "pgcrypto"; --для подключения функции рандомизации UUID

CREATE TABLE recommendations (
    product_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_name VARCHAR(100) NOT NULL,
    product_text VARCHAR NOT NULL
);