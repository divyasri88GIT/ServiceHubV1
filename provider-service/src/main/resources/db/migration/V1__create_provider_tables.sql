CREATE TABLE providers (
    id BIGSERIAL PRIMARY KEY,

    auth0_id VARCHAR(255) NOT NULL,

    business_name VARCHAR(255) NOT NULL,

    description TEXT,

    experience_years INTEGER,

    rating DOUBLE PRECISION,

    verified BOOLEAN DEFAULT FALSE,

    active BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP,

    updated_at TIMESTAMP
);

CREATE TABLE service_categories (
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(255) NOT NULL UNIQUE,

    description TEXT,

    active BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP,

    updated_at TIMESTAMP
);

CREATE TABLE provider_services (
    id BIGSERIAL PRIMARY KEY,

    provider_id BIGINT NOT NULL,

    category_id BIGINT NOT NULL,

    base_price DOUBLE PRECISION,

    active BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    CONSTRAINT fk_provider_service_provider
        FOREIGN KEY (provider_id)
        REFERENCES providers(id),

    CONSTRAINT fk_provider_service_category
        FOREIGN KEY (category_id)
        REFERENCES service_categories(id)
);

CREATE TABLE availability_slots (
    id BIGSERIAL PRIMARY KEY,

    provider_id BIGINT NOT NULL,

    day_of_week VARCHAR(20),

    start_time TIME,

    end_time TIME,

    available BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    CONSTRAINT fk_availability_provider
        FOREIGN KEY (provider_id)
        REFERENCES providers(id)
);