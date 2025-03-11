package com.example.education.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component
@Primary
public class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification: " + message);
    }

    @PostConstruct
    public void init() {
        System.out.println("EmailNotifier создан");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmailNotifier уничтожен");
    }
}