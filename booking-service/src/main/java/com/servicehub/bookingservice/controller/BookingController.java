package com.servicehub.bookingservice.controller;

import com.servicehub.bookingservice.dto.BookingResponse;
import com.servicehub.bookingservice.dto.BookingRequest;
import com.servicehub.bookingservice.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking-service/api")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse createBooking(@Valid @RequestBody BookingRequest request)
    {
    return bookingService.createBooking(request);
    }
    
}
