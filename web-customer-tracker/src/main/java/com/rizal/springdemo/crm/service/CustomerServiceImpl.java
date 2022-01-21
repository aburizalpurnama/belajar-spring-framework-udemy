package com.rizal.springdemo.crm.service;

import com.rizal.springdemo.crm.dao.CustomerDao;
import com.rizal.springdemo.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // inject CustomerDAO
    @Autowired
    private CustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }
}
