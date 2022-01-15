package com.rizal.springdemo.mvc.validator;

import com.rizal.springdemo.mvc.annotation.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("EmailConstraintValidator : contains @? " + s.contains("@"));
        System.out.println("EmailConstraintValidator : endsWith .com? " + s.endsWith(".com"));
        System.out.println("EmailConstraintValidator : endsWith .co.id? " + s.endsWith(".co.id"));

        return s != null && s.contains("@") && (s.endsWith(".com") || s.endsWith(".co.id"));
    }
}
