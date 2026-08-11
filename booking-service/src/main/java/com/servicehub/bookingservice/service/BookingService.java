package com.servicehub.bookingservice.service;

import com.servicehub.bookingservice.dto.BookingResponse;
import com.servicehub.bookingservice.dto.BookingRequest;

public interface BookingService {

    BookingResponse createBooking(BookingRequest request);
}
