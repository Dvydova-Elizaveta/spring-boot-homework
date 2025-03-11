package com.example.education.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SmsNotifier implements Notifier {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS notification: " + message);
    }

    @PostConstruct
    public void init() {
        System.out.println("SmsNotifier создан");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SmsNotifier уничтожен");
    }
}
