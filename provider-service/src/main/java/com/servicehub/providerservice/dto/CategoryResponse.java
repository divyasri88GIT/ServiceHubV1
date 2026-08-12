package com.servicehub.providerservice.dto;

public record CategoryResponse(
        Long id,
        String name,
        String description,
        Boolean active
) {

}
