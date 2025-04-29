package com.example.education.Listeners;

import com.example.education.events.SimpleEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TransactionalListener {
    @TransactionalEventListener
    public void onSimpleEvent(SimpleEvent event) {
        System.out.println("Транзакционный слушатель обработал событие: " + event.getMessage());
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommitEvent(SimpleEvent event) {
        System.out.println("Транзакционный слушатель перед коммитом: " + event.getMessage());
    }
}
