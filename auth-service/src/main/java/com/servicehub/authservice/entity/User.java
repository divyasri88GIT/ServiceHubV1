package com.servicehub.authservice.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auth0Id;

    @Column(unique = true, nullable = false)
    private String email;

    private String firstName;

    private String lastName;

    private String phone;

    private String profileImageUrl;

    private Boolean active;

    private Boolean emailVerified;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
