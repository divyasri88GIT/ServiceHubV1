package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.OfferingResponse;
import com.servicehub.providerservice.entity.ProviderOffering;
import com.servicehub.providerservice.repository.OfferingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferingServiceImpl implements OfferingService{

    private final OfferingRepository serviceRepository;
    @Override
    public List<OfferingResponse> getOfferingsByCategory(Long categoryId) {

        return serviceRepository
                .findByCategoryIdAndActiveTrue(categoryId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public OfferingResponse getOffering(Long offeringId) {

        ProviderOffering offering = serviceRepository.findById(offeringId).orElseThrow(
                () -> new RuntimeException("Provider Service not found")
        );

        return toResponse(offering);
    }

    private OfferingResponse toResponse(ProviderOffering offering) {

        return new OfferingResponse(offering.getId(),
                offering.getProvider().getId(),
                offering.getProvider().getBusinessName(),
                offering.getCategory().getId(),
                offering.getCategory().getName(),
                offering.getBasePrice(),
                offering.getActive());
    }
}
