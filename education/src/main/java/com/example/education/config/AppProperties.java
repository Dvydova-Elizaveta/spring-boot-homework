package com.example.education.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String name;
    private List<String> values;
    @Value("${app.env-var}")
    private String envVar;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getEnvVar() {
        return envVar;
    }

    public void setEnvVar(String envVar) {
        this.envVar = envVar;
    }
}
