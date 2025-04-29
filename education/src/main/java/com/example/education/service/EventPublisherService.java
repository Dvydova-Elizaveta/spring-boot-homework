package com.example.education.service;

import com.example.education.events.SimpleEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherService {
    private final ApplicationEventPublisher publisher;

    public EventPublisherService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishSimpleEvent(String message) {
        SimpleEvent event = new SimpleEvent(message);
        publisher.publishEvent(event);
        System.out.println("Порождено событие: " + message);
    }
}
