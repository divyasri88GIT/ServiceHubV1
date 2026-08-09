package com.servicehub.authservice.service;

import com.servicehub.authservice.entity.User;
import org.springframework.security.oauth2.jwt.Jwt;

public interface UserService {

    User sync(Jwt jwt);
}