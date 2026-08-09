package com.servicehub.providerservice.repository;

import com.servicehub.providerservice.entity.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {

}
