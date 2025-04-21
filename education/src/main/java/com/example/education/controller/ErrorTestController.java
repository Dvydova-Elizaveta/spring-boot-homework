package com.example.education.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorTestController {
    @GetMapping("/trigger-error")
    public String triggerError() {
        // Специально выбрасываем исключение (делим на ноль)
        int result = 1 / 0;
        return "Result: " + result;
    }
}
