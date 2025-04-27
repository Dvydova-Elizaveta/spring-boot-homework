package com.example.education.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;


@NotBlank(message = "Имя не может быть пустым")
@Size(min = 3, max = 20)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidUserName {
    String message() default "Некорректное имя пользователя";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
