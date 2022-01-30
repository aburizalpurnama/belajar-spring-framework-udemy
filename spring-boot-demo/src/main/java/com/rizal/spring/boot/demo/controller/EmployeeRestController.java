package com.rizal.spring.boot.demo.controller;

import com.rizal.spring.boot.demo.entity.Employee;
import com.rizal.spring.boot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Employee craeteEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Employee> getAllEmployee(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") int id){
        return employeeService.findEmployee(id);
    }

    @PutMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee newEmployee){
        return employeeService.updateEmployee(id, newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }
}
