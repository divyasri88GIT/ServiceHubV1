package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.*;

import java.util.List;

public interface ProviderService {

    ProviderResponse createProvider(String auth0Id, ProviderRequest request);

    ProviderResponse getProvider(Long id);

    List<ProviderResponse> getAllProviders();

    ProviderResponse updateProvider(Long id, ProviderRequest request);

    ServiceResponse assignService(Long providerId, ServiceRequest request);

    List<ServiceResponse> getServices(Long providerId);

    AvailabilityResponse createAvailability(Long providerId, AvailabilityRequest request);

    List<AvailabilityResponse> getAvailability(Long providerId);
}
