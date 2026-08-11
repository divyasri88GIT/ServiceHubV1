package com.servicehub.bookingservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String auth0Id;

    @Column(nullable = false)
    private String name;

    private String email;

    private String phone;

    private Boolean active;
}
