package com.rizal.springdemo.mvc.annotation;

import com.rizal.springdemo.mvc.validator.EmailConstraintValidator;
import org.springframework.validation.annotation.Validated;

import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Validated(value = EmailConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

    // define default value
    public String value() default "";

    // define default message
    public String message() default "please insert a valid email";

    // define default group
    public Class<?>[] group() default {};

    // define default payload
    public Class<? extends Payload>[] payload() default {};
}
