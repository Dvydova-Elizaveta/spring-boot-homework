package com.example.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceSetter {
    private Notifier notifier;

    @Autowired
    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.sendNotification(message);
    }
}