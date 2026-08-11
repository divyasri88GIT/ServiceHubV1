package com.servicehub.bookingservice.dto;

import java.util.UUID;

public record AvailabilitySlotResponse(
        Long id,
        Long providerId,
        boolean available
) {
}
