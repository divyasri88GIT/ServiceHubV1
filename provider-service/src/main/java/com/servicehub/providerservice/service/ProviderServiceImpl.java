package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.*;
import com.servicehub.providerservice.entity.Provider;
import com.servicehub.providerservice.entity.ServiceCategory;
import com.servicehub.providerservice.mapper.ProviderMapper;
import com.servicehub.providerservice.repository.AvailabilitySlotRepository;
import com.servicehub.providerservice.repository.ProviderRepository;
import com.servicehub.providerservice.entity.ProviderOffering;
import com.servicehub.providerservice.repository.ProviderServiceRepository;
import com.servicehub.providerservice.repository.ServiceCategoryRepository;
import com.servicehub.providerservice.entity.AvailabilitySlot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;
    private final ProviderServiceRepository providerServiceRepository;
    private final ServiceCategoryRepository categoryRepository;
    private final AvailabilitySlotRepository availabilitySlotRepository;

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

    @Override
    public ServiceResponse assignService(Long providerId, ServiceRequest request) {
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow();

        ServiceCategory category = categoryRepository.findById(request.categoryId()).orElseThrow();

        ProviderOffering service = new ProviderOffering();

        service.setProvider(provider);
        service.setCategory(category);
        service.setBasePrice(request.basePrice());
        service.setActive(true);

        ProviderOffering saved = providerServiceRepository.save(service);

        return new ServiceResponse(
                saved.getId(),
                category.getName(),
                saved.getBasePrice()
        );
    }

    @Override
    public List<ServiceResponse> getServices(@PathVariable Long providerId) {

        return providerServiceRepository
                .findByProviderId(providerId)
                .stream()
                .map(service -> new ServiceResponse(
                        service.getId(),
                        service.getCategory().getName(),
                        service.getBasePrice()
                ))
                .toList();
    }

    @Override
    public AvailabilityResponse createAvailability(Long providerId, AvailabilityRequest request) {
        Provider provider =
                providerRepository.findById(providerId)
                        .orElseThrow();

        AvailabilitySlot slot = new AvailabilitySlot();

        slot.setProvider(provider);

        slot.setDayOfWeek(request.dayOfWeek());

        slot.setStartTime(LocalTime.parse(request.startTime()));

        slot.setEndTime(LocalTime.parse(request.endTime()));

        slot.setAvailable(true);

        AvailabilitySlot saved = availabilitySlotRepository.save(slot);

        return new AvailabilityResponse(
                saved.getId(),
                saved.getDayOfWeek(),
                saved.getStartTime().toString(),
                saved.getEndTime().toString()
        );
    }

    @Override
    public List<AvailabilityResponse> getAvailability(Long providerId) {
        return availabilitySlotRepository
                .findByProviderId(providerId)
                .stream()
                .map(slot -> new AvailabilityResponse(
                        slot.getId(),
                        slot.getDayOfWeek(),
                        slot.getStartTime().toString(),
                        slot.getEndTime().toString()
                ))
                .toList();
    }
}
