package com.servicehub.bookingservice.service;

import com.servicehub.bookingservice.client.ProviderServiceClient;
import com.servicehub.bookingservice.dto.BookingResponse;
import com.servicehub.bookingservice.dto.BookingRequest;
import com.servicehub.bookingservice.dto.AvailabilitySlotResponse;
import com.servicehub.bookingservice.dto.OfferingResponse;
import com.servicehub.bookingservice.entity.Booking;
import com.servicehub.bookingservice.entity.BookingStatus;
import com.servicehub.bookingservice.exception.SlotAlreadyBookedException;
import com.servicehub.bookingservice.exception.SlotUnavailableException;
import com.servicehub.bookingservice.mapper.BookingMapper;
import com.servicehub.bookingservice.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final ProviderServiceClient providerServiceClient;

    @Override
    public BookingResponse createBooking(BookingRequest request) {

        OfferingResponse offering = providerServiceClient.getOffering(
                        request.offeringId()
                );

        AvailabilitySlotResponse slot = providerServiceClient.getSlot(
                        request.slotId()
                );

        if (!slot.available()) {
            throw new SlotUnavailableException();
        }

        bookingRepository.findBySlotId(request.slotId()).ifPresent(booking -> {
                    throw new SlotAlreadyBookedException();
                });

        if (!offering.providerId().equals(slot.providerId())) {
            throw new IllegalArgumentException("Offering and slot belong to different providers");
        }

        Booking booking = Booking.builder()
                .customerId(request.customerId())
                .providerId(offering.providerId())
                .offeringId(request.offeringId())
                .slotId(request.slotId())
                .status(BookingStatus.CONFIRMED)
                .totalPrice(offering.price())
                .build();

        booking = bookingRepository.save(booking);

        return bookingMapper.toResponse(booking);
    }
}
