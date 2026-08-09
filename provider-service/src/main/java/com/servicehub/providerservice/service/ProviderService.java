package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.ProviderRequest;
import com.servicehub.providerservice.dto.ProviderResponse;

import java.util.List;

public interface ProviderService {

    ProviderResponse createProvider(String auth0Id, ProviderRequest request);

    ProviderResponse getProvider(Long id);

    List<ProviderResponse> getAllProviders();

    ProviderResponse updateProvider(Long id, ProviderRequest request);
}
