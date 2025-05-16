package com.example.education.controller;

import com.example.education.metrics.ChocolateMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy")
public class ChocolateController {

    private final ChocolateMetrics chocolateMetrics;

    @Autowired
    public ChocolateController(ChocolateMetrics chocolateMetrics) {
        this.chocolateMetrics = chocolateMetrics;
    }

    @GetMapping("/{type}")
    public String buy(@PathVariable String type) {
        chocolateMetrics.recordPurchase(type);
        return "Bought: " + type;
    }
}
