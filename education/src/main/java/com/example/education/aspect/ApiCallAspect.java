package com.example.education.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
public class ApiCallAspect {
    @Value("${limit.max-api-calls}")
    private int maxCalls;

    private final Map<String, AtomicInteger> callCounter = new ConcurrentHashMap<>();

    @Around("@annotation(com.example.education.annotation.CountedApiCall)")
    public Object countApiCalls(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();

        callCounter.putIfAbsent(methodName, new AtomicInteger(0));
        int currentCount = callCounter.get(methodName).incrementAndGet();

        if (currentCount > maxCalls) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Количество запросов было превышено");
        }

        return joinPoint.proceed();
    }
}
