package com.rizal.springdemo.crm.service;

import com.rizal.springdemo.crm.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public List<Customer> getCustomers(int sortField);

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);

    public List<Customer> searchCustomerByName(String searchName);
}
