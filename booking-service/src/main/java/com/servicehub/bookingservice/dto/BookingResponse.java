package com.servicehub.bookingservice.dto;

import com.servicehub.bookingservice.entity.BookingStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record BookingResponse(
        Long id,
        Long customerId,
        Long providerId,
        Long offeringId,
        Long slotId,
        BookingStatus status,
        BigDecimal totalPrice
) {}