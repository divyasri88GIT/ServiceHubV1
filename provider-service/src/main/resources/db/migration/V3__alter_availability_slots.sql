ALTER TABLE availability_slots
DROP COLUMN provider_id;

ALTER TABLE availability_slots
    ADD COLUMN offering_id BIGINT NOT NULL;

ALTER TABLE availability_slots
    ADD CONSTRAINT fk_availability_offering
        FOREIGN KEY (offering_id)
            REFERENCES provider_services(id);