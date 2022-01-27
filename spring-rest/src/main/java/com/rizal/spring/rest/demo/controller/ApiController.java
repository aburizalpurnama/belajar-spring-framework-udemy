package com.rizal.spring.rest.demo.controller;

import com.rizal.spring.rest.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/students")
    public List<Student> getStudent(){
        return List.of(new Student("Jamal", "Mirdad"), new Student("Kucai", "Mamba"), new Student("Tikus", "Kaling"));
    }
}
