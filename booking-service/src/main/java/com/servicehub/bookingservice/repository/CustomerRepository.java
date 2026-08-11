package com.servicehub.bookingservice.repository;

import com.servicehub.bookingservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
