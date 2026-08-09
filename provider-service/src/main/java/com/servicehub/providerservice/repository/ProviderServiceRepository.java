package com.servicehub.providerservice.repository;

import com.servicehub.providerservice.entity.ProviderService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderServiceRepository extends JpaRepository<ProviderService, Long> {
}
