package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.OfferingResponse;
import com.servicehub.providerservice.entity.ProviderOffering;
import com.servicehub.providerservice.repository.OfferingRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
