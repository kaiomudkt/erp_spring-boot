CREATE TABLE IF NOT EXISTS TB_PRODUCTS (
    id_product UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    value NUMERIC(19, 2) NOT NULL
);
