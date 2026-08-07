--roles table creation
CREATE TABLE roles
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

--users table creation
CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,

    auth0_id VARCHAR(255),

    email VARCHAR(255) UNIQUE NOT NULL,

    full_name VARCHAR(255),

    phone VARCHAR(30),

    active BOOLEAN DEFAULT TRUE,

    role_id BIGINT REFERENCES roles(id)
);

--seed roles
INSERT INTO roles(name)
VALUES ('CUSTOMER');

INSERT INTO roles(name)
VALUES ('PROVIDER');

INSERT INTO roles(name)
VALUES ('ADMIN');