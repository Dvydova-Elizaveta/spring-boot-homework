package com.example.education.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
public class ApiController {
    @GetMapping("/public/api")
    public String publicApi() {
        return "Общий доступ.";
    }

    @RolesAllowed("admin")
    @GetMapping("/admin/api")
    public String adminApi(Authentication authentication) {
        return "Имя - " + authentication.getName() + ", Роль - admin.";
    }

    @RolesAllowed("support")
    @GetMapping("/support/api")
    public String supportApi(Authentication authentication) {
        return "Имя - " + authentication.getName() + ", Роль - support.";
    }
}
