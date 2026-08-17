package com.servicehub.bookingservice.controller;

import com.servicehub.bookingservice.dto.CustomerRequest;
import com.servicehub.bookingservice.dto.CustomerResponse;
import com.servicehub.bookingservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking-service/api")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public CustomerResponse createCustomer(@RequestBody CustomerRequest request) {

        return customerService.createCustomer("auth0|demo-customer", request);
    }

    @GetMapping("/{id}/customer")
    public CustomerResponse getCustomer(@PathVariable Long id) {

        return customerService.getCustomer(id);
    }

    @GetMapping("/customers")
    public List<CustomerResponse> getAllCustomers() {

        return customerService.getAllCustomers();
    }
}
