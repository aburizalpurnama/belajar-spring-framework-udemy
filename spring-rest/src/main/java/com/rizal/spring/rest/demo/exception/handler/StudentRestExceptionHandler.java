package com.rizal.spring.rest.demo.exception.handler;

import com.rizal.spring.rest.demo.entity.StudentErrorResponse;
import com.rizal.spring.rest.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handler method to catch out of range number of studentId
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotfoundException(StudentNotFoundException exc){

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add exception handler method to catch any exception throwed
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAnyException(Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
