package com.rizal.springdemo.mvc.controller;

import com.rizal.springdemo.mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showFrom(Model model){

        // create new student object
        Student student = new Student();

        // add the student object to model attribute
        model.addAttribute("student", student);

        // add the country options to model attribute
        model.addAttribute("countryOptions", countryOptions);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String procesForm(@ModelAttribute("student") Student student){

        // log the input data
        System.out.println("StudentController.processForm : value of object attribute ( the student : "
                + student.getFirstName() + " " + student.getLastName() + " )");

        return "student-confirmation";
    }
}
