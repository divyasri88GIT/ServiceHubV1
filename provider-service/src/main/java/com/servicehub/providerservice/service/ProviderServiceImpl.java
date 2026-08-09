package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.ProviderRequest;
import com.servicehub.providerservice.dto.ProviderResponse;
import com.servicehub.providerservice.entity.Provider;
import com.servicehub.providerservice.mapper.ProviderMapper;
import com.servicehub.providerservice.repository.ProviderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService{

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    @Override
    public ProviderResponse createProvider(
            String auth0Id,
            ProviderRequest request
    ) {

        Provider provider = new Provider();

        provider.setAuth0Id(auth0Id);
        provider.setBusinessName(request.businessName());
        provider.setDescription(request.description());
        provider.setExperienceYears(request.experienceYears());

        provider.setRating(0.0);
        provider.setVerified(false);
        provider.setActive(true);

        Provider saved = providerRepository.save(provider);

        return providerMapper.toResponse(saved);
    }

    @Override
    public ProviderResponse getProvider(Long id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        return providerMapper.toResponse(provider);
    }

    @Override
    public List<ProviderResponse> getAllProviders() {
        return providerRepository.findAll()
                .stream()
                .map(providerMapper::toResponse)
                .toList();
    }

    @Override
    public ProviderResponse updateProvider(Long id, ProviderRequest request) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        provider.setBusinessName(request.businessName());
        provider.setDescription(request.description());
        provider.setExperienceYears(request.experienceYears());

        Provider updated = providerRepository.save(provider);

        return providerMapper.toResponse(updated);
    }
}
