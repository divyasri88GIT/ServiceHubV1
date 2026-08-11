package com.servicehub.bookingservice.mapper;

import com.servicehub.bookingservice.dto.BookingResponse;
import com.servicehub.bookingservice.dto.CustomerResponse;
import com.servicehub.bookingservice.entity.Booking;
import com.servicehub.bookingservice.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingResponse toResponse(Booking booking);
    CustomerResponse toCustomerResponse(Customer customer);
}

