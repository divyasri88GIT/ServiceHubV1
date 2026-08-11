package com.servicehub.bookingservice.service;

import com.servicehub.bookingservice.dto.CustomerRequest;
import com.servicehub.bookingservice.dto.CustomerResponse;
import com.servicehub.bookingservice.entity.Customer;
import com.servicehub.bookingservice.mapper.BookingMapper;
import com.servicehub.bookingservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final BookingMapper bookingMapper;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(String auth0Id, CustomerRequest request) {

        Customer customer = new Customer();
        customer.setAuth0Id(auth0Id);
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setPhone(request.phone());
        customer.setActive(true);

        customer = customerRepository.save(customer);

        return bookingMapper.toCustomerResponse(customer);
    }

    @Override
    public CustomerResponse getCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).
                orElseThrow(() -> new RuntimeException("customer not found"));;
        return bookingMapper.toCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return List.of();
    }
}
