package com.servicehub.bookingservice.dto;

import java.math.BigDecimal;

public record OfferingResponse(
        Long offeringId,
        Long providerId,
        Double basePrice
) {
}
