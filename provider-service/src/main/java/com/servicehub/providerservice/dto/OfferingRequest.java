package com.servicehub.providerservice.dto;

public record OfferingRequest(Long categoryId,
                              Double basePrice,
                              Boolean active) {
}
