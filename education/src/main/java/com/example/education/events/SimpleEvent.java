package com.example.education.events;

public class SimpleEvent {
    private String message;

    public SimpleEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
