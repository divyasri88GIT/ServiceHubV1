package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.OfferingResponse;

import java.util.List;

public interface OfferingService {

    List<OfferingResponse> getOfferingsByCategory(Long categoryId);

    OfferingResponse getOffering(Long offeringId);
}
