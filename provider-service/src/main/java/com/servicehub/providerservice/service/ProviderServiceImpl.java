package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.*;
import com.servicehub.providerservice.entity.Provider;
import com.servicehub.providerservice.entity.ServiceCategory;
import com.servicehub.providerservice.entity.SlotAvailability;
import com.servicehub.providerservice.mapper.ProviderMapper;
import com.servicehub.providerservice.repository.AvailabilitySlotRepository;
import com.servicehub.providerservice.repository.ProviderRepository;
import com.servicehub.providerservice.entity.ProviderOffering;
import com.servicehub.providerservice.repository.OfferingRepository;
import com.servicehub.providerservice.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;
    private final OfferingRepository offeringRepository;
    private final CategoryRepository categoryRepository;
    private final AvailabilitySlotRepository availabilitySlotRepository;

    @Override
    public ProviderResponse createProvider(String auth0Id, ProviderRequest request) {

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
    public CategoryResponse assignService(Long providerId, CategoryRequest request) {
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow();

        ServiceCategory category = categoryRepository.findByName(request.name()).orElseThrow();

        ProviderOffering service = new ProviderOffering();

        service.setProvider(provider);
        service.setCategory(category);
        service.setActive(true);

        ProviderOffering saved = offeringRepository.save(service);

        return new CategoryResponse(
                saved.getId(),
                category.getName(),
                category.getDescription(),
                category.getActive()
        );
    }

    @Override
    public List<CategoryResponse> getServices(@PathVariable Long providerId) {

        return offeringRepository
                .findByProviderId(providerId)
                .stream()
                .map(service -> new CategoryResponse(
                        service.getId(),
                        service.getCategory().getName(),
                        service.getCategory().getDescription(),
                        service.getCategory().getActive()
                ))
                .toList();
    }

    public List<AvailabilityResponse> getSlotsByOffering(Long offeringId) {
        offeringRepository.findById(offeringId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Provider offering not found: " + offeringId));

        return availabilitySlotRepository
                .findByOfferingIdAndAvailableTrue(offeringId)
                .stream()
                .map(slot -> new AvailabilityResponse(
                        slot.getId(),
                        slot.getDayOfWeek(),
                        slot.getStartTime(),
                        slot.getEndTime(),
                        slot.getAvailable()
                ))
                .toList();
    }

    @Override
    public AvailabilityResponse getSlot(Long slotId) {

            return availabilitySlotRepository.findById(slotId)
                    .map(this::toAvailabilityResponse)
                    .orElseThrow(() -> new EntityNotFoundException("Slot not Available: " + slotId));


    }

    private AvailabilityResponse toAvailabilityResponse(SlotAvailability slotAvailability){

        return new AvailabilityResponse(
                slotAvailability.getId(),
                slotAvailability.getDayOfWeek(),
                slotAvailability.getStartTime(),
                slotAvailability.getEndTime(),
                slotAvailability.getAvailable());

    }
}
