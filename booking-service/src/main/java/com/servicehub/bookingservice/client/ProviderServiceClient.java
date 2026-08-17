package com.servicehub.bookingservice.client;

import com.servicehub.bookingservice.dto.AvailabilitySlotResponse;
import com.servicehub.bookingservice.dto.OfferingResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
//@RequiredArgsConstructor
public class ProviderServiceClient {


    private final RestClient.Builder restClientBuilder;

    public ProviderServiceClient(
            @Qualifier("loadBalancedRestClientBuilder")
            RestClient.Builder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    public OfferingResponse getOffering(Long offeringId) {
        return restClientBuilder.build()
                .get()
                .uri(
                        "http://provider-service/provider-service/api/{offeringId}/offering",
                        offeringId
                )
                .retrieve()
                .body(OfferingResponse.class);
    }

    public AvailabilitySlotResponse getSlot(Long slotId) {
        return restClientBuilder.build()
                .get()
                .uri(
                        "http://provider-service/provider-service/api/{slotId}/slot",
                        slotId
                )
                .retrieve()
                .body(AvailabilitySlotResponse.class);
    }
}
