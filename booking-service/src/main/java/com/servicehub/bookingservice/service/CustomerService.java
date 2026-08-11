package com.servicehub.bookingservice.service;

import com.servicehub.bookingservice.dto.CustomerRequest;
import com.servicehub.bookingservice.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(String auth0Id, CustomerRequest request);
    CustomerResponse getCustomer(Long customerId);
    List<CustomerResponse> getAllCustomers();

}
