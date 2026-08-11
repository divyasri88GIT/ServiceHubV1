package com.servicehub.bookingservice.exception;

public class SlotUnavailableException extends RuntimeException {

    public SlotUnavailableException() {
        super("Selected slot is unavailable");
    }
}
