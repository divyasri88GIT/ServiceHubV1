package com.servicehub.providerservice.dto;

public record ProviderResponse(
                               Long id,
                               String auth0Id,
                               String businessName,
                               String description,
                               Integer experienceYears,
                               Double rating,
                               Boolean verified,
                               Boolean active
) {
}
