package com.servicehub.providerservice.repository;

import com.servicehub.providerservice.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
