package com.rizal.spring.boot.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @Size(min = 3, max = 45)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 3, max = 45)
    private String lastName;

    @Email
    @Size(min = 3, max = 45)
    private String email;
}
