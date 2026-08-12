package com.servicehub.providerservice.repository;

import com.servicehub.providerservice.entity.SlotAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilitySlotRepository extends JpaRepository<SlotAvailability, Long> {
    
    List<SlotAvailability> findByOfferingIdAndAvailableTrue(Long providerId);

}
