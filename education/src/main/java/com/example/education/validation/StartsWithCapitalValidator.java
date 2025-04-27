package com.example.education.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartsWithCapitalValidator implements ConstraintValidator<StartsWithCapitalLetter, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty() && Character.isUpperCase(value.charAt(0));
    }
}
