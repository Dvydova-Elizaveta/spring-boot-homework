package com.example.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceField {
    @Autowired
    private Notifier notifier;

    public void send(String message) {
        notifier.sendNotification(message);
    }
}