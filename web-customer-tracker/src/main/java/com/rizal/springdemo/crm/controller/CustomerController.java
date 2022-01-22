package com.rizal.springdemo.crm.controller;

import com.rizal.springdemo.crm.entity.Customer;
import com.rizal.springdemo.crm.service.CustomerService;
import com.rizal.springdemo.crm.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private Logger logger = Logger.getLogger(getClass().getName());

    // inject customerDao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model, @RequestParam(value = "sort", required = false) String sort){

        // get data
        List<Customer> customers = null;

        // check sort field value
        if(sort != null){
            int sortInt = Integer.parseInt(sort);
            customers = customerService.getCustomers(sortInt);
        } else {
            // if sort args is null, sort data by last name
            customers = customerService.getCustomers(SortUtil.LAST_NAME);
        }

        // add data to model
        model.addAttribute("customers", customers);

        logger.info("sort value : " + sort);

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
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model){

        // get customer from database
        Customer customer = customerService.getCustomer(id);

        // set customer to populate the form
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id){

        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String searchName, Model model){

        // search customer from service
        List<Customer> customers = customerService.searchCustomerByName(searchName);

        // add the customer to model
        model.addAttribute("customers", customers);

        return "list-customers";
    }

}
