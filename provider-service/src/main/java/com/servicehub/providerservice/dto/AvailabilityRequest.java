package com.servicehub.providerservice.dto;

import java.time.DayOfWeek;

public record AvailabilityRequest(
        DayOfWeek dayOfWeek,
        String startTime,
        String endTime) {
}
