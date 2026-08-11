CREATE TABLE bookings (
                          id BIGSERIAL PRIMARY KEY,
                          customer_id BIGINT NOT NULL,
                          provider_id BIGINT NOT NULL,
                          offering_id BIGINT NOT NULL,
                          slot_id BIGINT NOT NULL,
                          status VARCHAR(50) NOT NULL,
                          total_price NUMERIC(10,2) NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                          CONSTRAINT uk_booking_slot UNIQUE (slot_id)
);

CREATE TABLE customers (
                          id BIGSERIAL PRIMARY KEY,
                          auth0_id VARCHAR(255) NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          phone VARCHAR(50) NOT NULL,
                          active BOOLEAN NOT NULL DEFAULT TRUE,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

);
