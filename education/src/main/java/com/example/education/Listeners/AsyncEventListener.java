package com.example.education.Listeners;


import com.example.education.events.SimpleEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncEventListener {

    @EventListener
    @Async
    public void onSimpleEvent(SimpleEvent event) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Асинхронный слушатель обработал событие: " + event.getMessage());
    }
}
