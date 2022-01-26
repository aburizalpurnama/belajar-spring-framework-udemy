package com.rizal.json.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private boolean active;
    private String[] friends;
    private Instructor instructor;
    private List<Course> courses;

}
