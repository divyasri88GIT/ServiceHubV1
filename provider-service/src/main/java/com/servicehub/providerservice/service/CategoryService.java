package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.CategoryResponse;
import com.servicehub.providerservice.dto.CategoryRequest;

import java.util.List;

public interface CategoryService {

        CategoryResponse create(CategoryRequest request);

        List<CategoryResponse> getAll();

        CategoryResponse getById(Long id);

}
