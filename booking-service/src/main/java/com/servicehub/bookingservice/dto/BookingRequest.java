package com.servicehub.bookingservice.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record BookingRequest(

        @NotNull(message = "customer ID is required")
        Long customerId,

        @NotNull(message = "Offering ID is required")
        Long offeringId,

        @NotNull(message = "Slot ID is required")
        Long slotId) {
}
