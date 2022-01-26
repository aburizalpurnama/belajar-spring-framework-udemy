package com.rizal.json.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private boolean active;
    private String[] friends;
    private Instructor instructor;
    private List<Course> courses;

}
