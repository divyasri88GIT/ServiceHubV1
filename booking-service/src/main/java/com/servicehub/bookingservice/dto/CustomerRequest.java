package com.servicehub.bookingservice.dto;

public record CustomerRequest(
        String name,
        String email,
        String phone) {
}
