CREATE TABLE IF NOT EXISTS TB_USERS (
    id_product UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    login VARCHAR(255),
    password VARCHAR(255),
    birth_at DATE,
    created_by_id UUID REFERENCES TB_USERS(id_product),
    updated_by_id UUID REFERENCES TB_USERS(id_product),
    deleted_by_id UUID REFERENCES TB_USERS(id_product),
    deleted_at_date DATE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
