package com.servicehub.providerservice.repository;

import com.servicehub.providerservice.entity.AvailabilitySlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot, Long> {
}
