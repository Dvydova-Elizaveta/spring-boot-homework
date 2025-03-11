package com.example.education;

import com.example.education.service.NotificationServiceConstructor;
import com.example.education.service.NotificationServiceField;
import com.example.education.service.NotificationServiceSetter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationApplication.class, args);
	}

	@Bean
	CommandLineRunner run(
			NotificationServiceConstructor constructorService,
			NotificationServiceField fieldService,
			NotificationServiceSetter setterService) {
		return args -> {
			constructorService.send("Реализация конструктором.");
			fieldService.send("Реализация полем.");
			setterService.send("Реализация сеттером.");
		};
	}

}
