package com.servicehub.providerservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "provider_services")
@Getter
@Setter
@NoArgsConstructor
public class ProviderService extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ServiceCategory category;

    private Double basePrice;

    private Boolean active;
}
