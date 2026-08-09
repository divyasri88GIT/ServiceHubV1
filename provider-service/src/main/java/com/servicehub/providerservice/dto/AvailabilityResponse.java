package com.servicehub.providerservice.dto;

import java.time.DayOfWeek;

public record AvailabilityResponse(
        Long id,
        DayOfWeek dayOfWeek,
        String startTime,
        String endTime
) {
}
