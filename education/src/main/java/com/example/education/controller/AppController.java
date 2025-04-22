package com.example.education.controller;

import com.example.education.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private final AppProperties properties;


    public AppController(AppProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/info")
    public AppProperties getInfo() {
        return properties;
    }
}
