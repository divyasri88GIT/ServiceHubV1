package com.servicehub.providerservice.mapper;

import com.servicehub.providerservice.dto.CategoryRequest;
import com.servicehub.providerservice.dto.CategoryResponse;
import com.servicehub.providerservice.entity.ServiceCategory;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper {


    ServiceCategory toEntity(CategoryRequest request);

    CategoryResponse toDto(ServiceCategory serviceCategory);
}
