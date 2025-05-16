package com.example.education.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Endpoint(id = "log-time")
public class LogTimeEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(LogTimeEndpoint.class);

    @ReadOperation
    public String logTime() {
        String message = "Custom actuator called at: " + LocalDateTime.now();
        logger.info(message);
        return message;
    }
}