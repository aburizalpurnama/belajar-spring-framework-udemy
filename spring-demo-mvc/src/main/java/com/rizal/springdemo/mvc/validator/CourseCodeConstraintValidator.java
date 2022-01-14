package com.rizal.springdemo.mvc.validator;

import com.rizal.springdemo.mvc.annotation.CourseCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefixes;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefixes = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;

        if (courseCode != null) {

            // iterate coursePrefixes & check if code match any prefixes
            for (var code : coursePrefixes){
                result = courseCode.startsWith(code);

                if (result){
                    break;
                }
            }
        } else {
            result = true;
        }

        return result;
    }
}
