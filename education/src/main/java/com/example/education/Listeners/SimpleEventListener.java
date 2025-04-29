package com.example.education.Listeners;

import com.example.education.events.SimpleEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleEventListener {

    @EventListener
    public void onSimpleEvent(SimpleEvent event) {
        System.out.println("Обычный слушатель обработал событие: " + event.getMessage());
    }
}
