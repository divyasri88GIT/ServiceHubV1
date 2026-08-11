package com.servicehub.bookingservice.repository;

import com.servicehub.bookingservice.entity.Booking;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {


    List<Booking> findByCustomerId(Long customerId);

    List<Booking> findByProviderId(Long providerId);

    Optional<Booking> findBySlotId(@NotNull(message = "Slot ID is required") Long slotId);
}
