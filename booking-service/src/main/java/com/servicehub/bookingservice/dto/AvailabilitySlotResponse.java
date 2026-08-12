package com.servicehub.bookingservice.dto;

public record AvailabilitySlotResponse(
        Long id,
        Long offeringId,
        boolean available
) {
}
