package com.example.education.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;


@Component
public class ChocolateMetrics {

    private final Counter kitkat;
    private final Counter snickers;
    private final Counter twix;

    public ChocolateMetrics(MeterRegistry registry) {
        kitkat = Counter.builder("choco.kitkat.count").description("KitKats bought").register(registry);
        snickers = Counter.builder("choco.snickers.count").description("Snickers bought").register(registry);
        twix = Counter.builder("choco.twix.count").description("Twix bought").register(registry);
    }


    public void recordPurchase(String type) {
        switch (type.toLowerCase()) {
            case "kitkat" -> kitkat.increment();
            case "snickers" -> snickers.increment();
            case "twix" -> twix.increment();
        }
    }
}
