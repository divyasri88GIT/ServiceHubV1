package com.servicehub.bookingservice.exception;

public class SlotAlreadyBookedException extends RuntimeException {

    public SlotAlreadyBookedException() {
        super("Slot is already booked");
    }
}
