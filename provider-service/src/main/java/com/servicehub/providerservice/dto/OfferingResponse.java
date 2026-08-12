package com.servicehub.providerservice.dto;

public record OfferingResponse(
        Long offeringId,
        Long providerId,
        String providerName,
        Long categoryId,
        String categoryName,
        Double basePrice,
        Boolean active
) {
}
