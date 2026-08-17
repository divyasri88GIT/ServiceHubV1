package com.servicehub.providerservice.controller;

import com.servicehub.providerservice.dto.CategoryRequest;
import com.servicehub.providerservice.dto.CategoryResponse;
import com.servicehub.providerservice.dto.OfferingResponse;
import com.servicehub.providerservice.service.CategoryService;
import com.servicehub.providerservice.service.OfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider-service/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final OfferingService offeringService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(@RequestBody CategoryRequest request) {

        return service.create(request);
    }

    @GetMapping("/categories")
    public List<CategoryResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/category/{id}")
    public CategoryResponse getById(@PathVariable Long id) {

        return service.getById(id);
    }

//    @GetMapping("/offerings")
//    public List<OfferingResponse> getAllOfferings() {
//
//        return offeringService.getAll();
//    }

    @GetMapping("/{categoryId}/offerings")
    public List<OfferingResponse> getOfferingsByCategory(@PathVariable Long categoryId) {

        return offeringService.getOfferingsByCategory(categoryId);
    }

    @GetMapping("/{offeringId}/offering")
    public OfferingResponse getOffering(@PathVariable Long offeringId) {

        return offeringService.getOffering(offeringId);
    }
}

