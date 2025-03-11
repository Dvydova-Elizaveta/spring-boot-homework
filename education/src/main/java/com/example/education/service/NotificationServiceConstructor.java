package com.example.education.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceConstructor {
    private final Notifier notifier;

    public NotificationServiceConstructor(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.sendNotification(message);
    }
}