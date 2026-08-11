package com.servicehub.bookingservice.dto;

public record CustomerResponse(Long id,
                               String auth0Id,
                               String name,
                               String email,
                               String phone,
                               boolean active) {
}
