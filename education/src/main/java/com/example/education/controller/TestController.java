package com.example.education.controller;

import com.example.education.annotation.CountedApiCall;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    @CountedApiCall
    public String hello() {
        return "Hello!";
    }
}
