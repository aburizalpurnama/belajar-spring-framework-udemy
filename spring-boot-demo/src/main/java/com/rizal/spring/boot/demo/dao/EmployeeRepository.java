package com.rizal.spring.boot.demo.dao;

import com.rizal.spring.boot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
