package com.rizal.spring.rest.demo.controller;

import com.rizal.spring.rest.demo.entity.Student;
import com.rizal.spring.rest.demo.entity.StudentErrorResponse;
import com.rizal.spring.rest.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = List.of(new Student("Jamal", "Mirdad"),
                new Student("Kucai", "Mamba"),
                new Student("Tikus", "Kaling"),
                new Student("Gilang", "Uhuy"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return List.of(new Student("Jamal", "Mirdad"),
                new Student("Kucai", "Mamba"),
                new Student("Tikus", "Kaling"));
    }

    // define endpoint for with index parameter
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check is studentId passed out of bounds ?
        if ((studentId >= students.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found '" + studentId + "'");
        }
        return students.get(studentId);
    }
}
