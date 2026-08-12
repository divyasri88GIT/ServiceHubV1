package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.*;

import java.util.List;

public interface ProviderService {

    ProviderResponse createProvider(String auth0Id, ProviderRequest request);

    ProviderResponse getProvider(Long id);

    List<ProviderResponse> getAllProviders();

    ProviderResponse updateProvider(Long id, ProviderRequest request);

    CategoryResponse assignService(Long providerId, CategoryRequest request);

    List<CategoryResponse> getServices(Long providerId);

    List<AvailabilityResponse> getSlotsByOffering(Long offeringId);

    AvailabilityResponse getSlot(Long slotId);

}
