package com.rizal.springdemo.crm.controller;

import com.rizal.springdemo.crm.dao.CustomerDao;
import com.rizal.springdemo.crm.entity.Customer;
import com.rizal.springdemo.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // inject customerDao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        // get data
        List<Customer> customers = customerService.getCustomers();

        // add data to model
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
