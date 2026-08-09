package com.servicehub.providerservice.controller;


import com.servicehub.providerservice.dto.ProviderRequest;
import com.servicehub.providerservice.dto.ProviderResponse;
import com.servicehub.providerservice.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping
    public ProviderResponse createProvider(@RequestBody ProviderRequest request) {
        return providerService.createProvider("auth0|demo-user", request);
    }

    @GetMapping("/{id}")
    public ProviderResponse getProvider(@PathVariable Long id) {
        return providerService.getProvider(id);
    }

    @GetMapping
    public List<ProviderResponse> getAllProviders() {
        return providerService.getAllProviders();
    }

    @PutMapping("/{id}")
    public ProviderResponse updateProvider(@PathVariable Long id, @RequestBody ProviderRequest request) {
        return providerService.updateProvider(id, request);
    }
}
