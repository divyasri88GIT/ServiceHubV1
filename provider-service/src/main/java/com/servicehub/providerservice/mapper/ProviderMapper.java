package com.servicehub.providerservice.mapper;

import com.servicehub.providerservice.dto.ProviderResponse;
import com.servicehub.providerservice.entity.Provider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

    ProviderResponse toResponse(Provider provider);
}
