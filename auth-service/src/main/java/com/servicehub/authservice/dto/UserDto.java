package com.servicehub.authservice.dto;

public record UserDto(Long id,
                      String email,
                      String firstName,
                      String lastName) {
}
