CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       functional_code VARCHAR(30) NOT NULL UNIQUE,
                       phone VARCHAR(20) NOT NULL,
                       location VARCHAR(100) NOT NULL,
                       role VARCHAR(30) NOT NULL
);