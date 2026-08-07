package com.servicehub.authservice.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
}