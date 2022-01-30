package com.rizal.spring.boot.demo.service;

import com.rizal.spring.boot.demo.dao.EmployeeDao;
import com.rizal.spring.boot.demo.entity.Employee;
import com.rizal.spring.boot.demo.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Iterable<Employee> findAllEmployee(){
        return employeeDao.findAll();
    }

    public Employee findEmployee(int id){
        return employeeDao.findById(id).orElse(null);
    }

    public Employee updateEmployee(int id, Employee newEmployee){
        return employeeDao.findById(id).map(employee -> {
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setEmail(newEmployee.getEmail());
            return employeeDao.save(employee);
        }).orElseGet(() ->{
            newEmployee.setId(id);
            return employeeDao.save(newEmployee);
        });
    }

    public void deleteEmployee(int id){
        employeeDao.delete(employeeDao.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found, id='" + id +"'")));
    }

    public Employee createEmployee(Employee employee){
        return employeeDao.save(employee);
    }

}
