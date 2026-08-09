package com.servicehub.providerservice.repository;

import com.servicehub.providerservice.entity.ProviderOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderServiceRepository extends JpaRepository<ProviderOffering, Long> {
    List<ProviderOffering> findByProviderId(Long providerId);
}
