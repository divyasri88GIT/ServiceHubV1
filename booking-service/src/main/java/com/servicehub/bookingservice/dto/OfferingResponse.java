package com.servicehub.bookingservice.dto;

import java.math.BigDecimal;

public record OfferingResponse(
        Long id,
        Long providerId,
        BigDecimal price
) {
}
