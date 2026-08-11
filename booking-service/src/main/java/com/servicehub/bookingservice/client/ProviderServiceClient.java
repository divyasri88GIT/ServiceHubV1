package com.servicehub.bookingservice.client;

import com.servicehub.bookingservice.dto.AvailabilitySlotResponse;
import com.servicehub.bookingservice.dto.OfferingResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class ProviderServiceClient {

//    private final RestClient restClient;
private final RestClient.Builder restClientBuilder;

//    public ProviderServiceClient(@Lazy RestClient restClient) {
//        this.restClient = restClient;
//    }

    public OfferingResponse getOffering(@NotNull(message = "Offering ID is required") Long offeringId) {
        return restClientBuilder.build().get()
                .uri("http://provider-service/api/provider/{providerId}/services", offeringId)
                .retrieve()
                .body(OfferingResponse.class);
    }

    public AvailabilitySlotResponse getSlot(@NotNull(message = "Slot ID is required") Long slotId) {
        return restClientBuilder.build().get()
                .uri("http://provider-service/api/provider/{providerId}/availability", slotId)
                .retrieve()
                .body(AvailabilitySlotResponse.class);
    }
}
