package com.servicehub.providerservice.service;

import com.servicehub.providerservice.dto.CategoryRequest;
import com.servicehub.providerservice.dto.CategoryResponse;
import com.servicehub.providerservice.entity.ServiceCategory;
import com.servicehub.providerservice.mapper.CategoryMapper;
import com.servicehub.providerservice.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public CategoryResponse create(CategoryRequest request) {

        repository.findByName(request.name())
                .ifPresent(category -> {
                    throw new IllegalArgumentException(
                            "Service category already exists: " + request.name());
                });

        ServiceCategory category = mapper.toEntity(request);

        if (category.getActive() == null) {
            category.setActive(Boolean.TRUE);
        }

        return mapper.toDto(repository.save(category));
    }

    @Override
    public List<CategoryResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CategoryResponse getById(Long id) {

        ServiceCategory category = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Service category not found with id: " + id));

        return mapper.toDto(category);
    }


}
