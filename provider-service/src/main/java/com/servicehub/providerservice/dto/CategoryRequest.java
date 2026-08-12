package com.servicehub.providerservice.dto;

public record CategoryRequest(
        String name,
        String description,
        Boolean active
) {
}
