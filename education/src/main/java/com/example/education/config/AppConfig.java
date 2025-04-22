package com.example.education.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("test")
    public String TestBean() {
        System.out.println("Запущен бин, который создается, только если профиль test");
        return "Запущен бин, который создается, только если профиль test";
    }

    @Bean
    @ConditionalOnBean(name = "TestBean")
    public String NextDependentBean() {
        System.out.println("Запущен бин, который  создается, если существует первый бин");
        return "Запущен бин, который  создается, если существует первый бин";
    }

    @Bean
    @ConditionalOnExpression("!'${EXAMPLE_TEST:default}'.equals('default')")
    public String EnvDependentBean() {
        System.out.println("Запущен бин, который  создается, если в конфиге EXAMPLE_TEST (env var) не “default”");
        return "Запущен бин, который  создается, если в конфиге EXAMPLE_TEST (env var) не “default”";
    }
}
