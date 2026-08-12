package com.servicehub.providerservice.repository;

import com.servicehub.providerservice.entity.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<ServiceCategory, Long> {

        Optional<ServiceCategory> findByName(String name);
//        Optional<ServiceCategory> findById(Long id);
//        Optional<ServiceCategory> findAll();

}
