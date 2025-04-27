package com.example.education.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StartsWithCapitalValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface StartsWithCapitalLetter {
    String message() default "Поле должно начинаться с заглавной буквы";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}