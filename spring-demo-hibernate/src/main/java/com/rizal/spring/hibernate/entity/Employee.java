package com.rizal.spring.hibernate.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "company")
    private String company;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String company, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.dateOfBirth = dateOfBirth;
    }
}
