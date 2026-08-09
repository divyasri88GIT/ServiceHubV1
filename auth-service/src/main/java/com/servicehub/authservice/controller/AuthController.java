package com.servicehub.authservice.controller;

import com.servicehub.authservice.dto.UserDto;
import com.servicehub.authservice.entity.User;
import com.servicehub.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String health() {

        return "AUTH SERVICE UP";
    }


    @GetMapping("/me")
    public Map<String, Object> me(JwtAuthenticationToken token) {
        return token.getTokenAttributes();
    }
}
