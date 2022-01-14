package com.rizal.springdemo.mvc.validator;

import com.rizal.springdemo.mvc.annotation.CourseCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
        if (courseCode != null) {
            return courseCode.startsWith(coursePrefix);
        } else {
            return true;
        }
    }
}
