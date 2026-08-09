package com.servicehub.providerservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "providers")
@Getter
@Setter
@NoArgsConstructor
public class Provider extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String auth0Id;

    @Column(nullable = false)
    private String businessName;

    private String description;

    private Integer experienceYears;

    private Double rating;

    private Boolean verified;

    private Boolean active;
}
