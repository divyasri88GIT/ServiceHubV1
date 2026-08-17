package com.servicehub.providerservice.controller;


import com.servicehub.providerservice.dto.*;
import com.servicehub.providerservice.service.OfferingService;
import com.servicehub.providerservice.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider-service/api")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping("/provider")
    public ProviderResponse createProvider(@RequestBody ProviderRequest request) {
        return providerService.createProvider("auth0|demo-user", request);
    }

    @GetMapping("/provider/{id}")
    public ProviderResponse getProvider(@PathVariable Long id) {
        return providerService.getProvider(id);
    }

    @GetMapping
    public List<ProviderResponse> getAllProviders() {
        return providerService.getAllProviders();
    }

    @PutMapping("/provider/{id}")
    public ProviderResponse updateProvider(@PathVariable Long id, @RequestBody ProviderRequest request) {
        return providerService.updateProvider(id, request);
    }

    @PostMapping("/{providerId}/service")
    public OfferingResponse assignService(@PathVariable Long providerId, @RequestBody OfferingRequest request) {

        return providerService.assignService(providerId, request);
    }

    @GetMapping("/{providerId}/services")
    public List<CategoryResponse> getServices(@PathVariable Long providerId) {

        return providerService.getServices(providerId);
    }

    @PostMapping("/{offeringId}/slot")
    public AvailabilityResponse createSlot(@PathVariable Long offeringId, @RequestBody AvailabilityRequest request) {

        return providerService.createSlot(offeringId, request);
    }

    @GetMapping("/{offeringId}/slots")
    public List<AvailabilityResponse> getSlotsByOffering(@PathVariable Long offeringId) {

        return providerService.getSlotsByOffering(offeringId);
    }

    @GetMapping("/{slotId}/slot")
    public AvailabilityResponse getSlot(@PathVariable Long slotId) {

        return providerService.getSlot(slotId);

    }

}
