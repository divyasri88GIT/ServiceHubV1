package com.servicehub.providerservice.repository;

import com.servicehub.providerservice.entity.AvailabilitySlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot, Long> {
    List<AvailabilitySlot> findByProviderId(Long providerId);
}
