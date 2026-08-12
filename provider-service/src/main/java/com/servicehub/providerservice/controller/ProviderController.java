package com.servicehub.providerservice.controller;


import com.servicehub.providerservice.dto.*;
import com.servicehub.providerservice.service.OfferingService;
import com.servicehub.providerservice.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider-service/api/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping
    public ProviderResponse createProvider(@RequestBody ProviderRequest request) {
        return providerService.createProvider("auth0|demo-user", request);
    }

    @GetMapping("/{id}")
    public ProviderResponse getProvider(@PathVariable Long id) {
        return providerService.getProvider(id);
    }

    @GetMapping
    public List<ProviderResponse> getAllProviders() {
        return providerService.getAllProviders();
    }

    @PutMapping("/{id}")
    public ProviderResponse updateProvider(@PathVariable Long id, @RequestBody ProviderRequest request) {
        return providerService.updateProvider(id, request);
    }

    @PostMapping("/{providerId}/services")
    public CategoryResponse assignService(
            @PathVariable Long providerId,
            @RequestBody CategoryRequest request) {

        return providerService.assignService(
                providerId,
                request);
    }

    @GetMapping("/{providerId}/services")
    public List<CategoryResponse> getServices(
            @PathVariable Long providerId) {

        return providerService.getServices(providerId);
    }

    @GetMapping("/{OfferingId}/slots")
    public List<AvailabilityResponse> getSlotsByOffering(@PathVariable Long offeringId) {

        return providerService.getSlotsByOffering(offeringId);
    }

    @GetMapping("/{slotId}/slot")
    public AvailabilityResponse getSlot(@PathVariable Long slotId) {

        return providerService.getSlot(slotId);

    }

}
