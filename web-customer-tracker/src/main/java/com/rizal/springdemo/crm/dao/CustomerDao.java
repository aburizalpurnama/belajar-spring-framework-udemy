package com.rizal.springdemo.crm.dao;

import com.rizal.springdemo.crm.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
