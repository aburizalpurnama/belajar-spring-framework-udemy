package com.rizal.springdemo.crm.controller;

import com.rizal.springdemo.crm.entity.Customer;
import com.rizal.springdemo.crm.exception.CustomerNotFoundException;
import com.rizal.springdemo.crm.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null){
            throw new CustomerNotFoundException("Customer not found, id : '" + customerId + "'");
        }
        return customer;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public void insertCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    @PutMapping("/customers/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@PathVariable("customerId") int id, @RequestBody Customer newCust){
        Customer oldCust = customerService.getCustomer(id);
        if (oldCust == null){
            logger.info("Customer not found : " + id);
            return;
        }
        BeanUtils.copyProperties(newCust, oldCust);
        oldCust.setId(id);
        customerService.saveCustomer(oldCust);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer2(@RequestBody Customer newCust){
        customerService.saveCustomer(newCust);
    }

    @DeleteMapping("/customers/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable int customerId){
        if (customerService.getCustomer(customerId) == null){
            throw new CustomerNotFoundException("Customer not exist with id : '" +customerId+"'");
        }
        customerService.deleteCustomer(customerId);
    }
}
