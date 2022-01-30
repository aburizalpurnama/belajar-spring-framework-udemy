package com.rizal.spring.boot.demo.dao;

import com.rizal.spring.boot.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
