package com.servicehub.authservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/health")
    public String health() {
        return "AUTH SERVICE UP";
    }
}
