package com.servicehub.providerservice.controller;


import com.servicehub.providerservice.dto.*;
import com.servicehub.providerservice.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
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
    public ServiceResponse assignService(
            @PathVariable Long providerId,
            @RequestBody ServiceRequest request) {

        return providerService.assignService(
                providerId,
                request);
    }

    @GetMapping("/{providerId}/services")
    public List<ServiceResponse> getServices(
            @PathVariable Long providerId) {

        return providerService.getServices(
                providerId);
    }

    @PostMapping("/{providerId}/availability")
    public AvailabilityResponse createAvailability(
            @PathVariable Long providerId,
            @RequestBody AvailabilityRequest request) {

        return providerService.createAvailability(
                providerId,
                request);
    }

    @GetMapping("/{providerId}/availability")
    public List<AvailabilityResponse> getAvailability(
            @PathVariable Long providerId) {

        return providerService.getAvailability(
                providerId);
    }
}
