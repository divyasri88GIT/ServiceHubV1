package com.servicehub.bookingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SlotUnavailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleSlotUnavailable(
            SlotUnavailableException ex
    ) {
        return Map.of("message", ex.getMessage());
    }

    @ExceptionHandler(SlotAlreadyBookedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleSlotAlreadyBooked(
            SlotAlreadyBookedException ex
    ) {
        return Map.of("message", ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgument(
            IllegalArgumentException ex
    ) {
        return Map.of("message", ex.getMessage());
    }

}
