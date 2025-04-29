package com.example.education.controller;

import com.example.education.service.EventPublisherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    private final EventPublisherService eventPublisherService;

    public EventController(EventPublisherService eventPublisherService) {
        this.eventPublisherService = eventPublisherService;
    }

    @GetMapping("/test-events")
    public String testEvents() {
        eventPublisherService.publishSimpleEvent("Событие 1");
        eventPublisherService.publishSimpleEvent("Событие 2");
        return "События отправлены!";
    }
}
