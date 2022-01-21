package com.rizal.springdemo.crm.controller;

import com.rizal.springdemo.crm.dao.CustomerDao;
import com.rizal.springdemo.crm.entity.Customer;
import com.rizal.springdemo.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        // create model attribute to bind form data
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,
                                    Model model){

        // get customer from database
        Customer customer = customerService.getCustomer(id);

        // set customer to populate the form
        model.addAttribute("customer", customer);

        return "customer-form";
    }
}
