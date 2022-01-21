package com.rizal.springdemo.crm.dao;

import com.rizal.springdemo.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(){
        // get current session
        Session session = sessionFactory.getCurrentSession();

        //create query
        Query<Customer> query = session.createQuery("from Customer order by lastName",
                                                    Customer.class);

        // get the result set
        List<Customer> listCustomers = query.getResultList();

        return listCustomers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        // saveOrUpdate : save new data if id = null, and update existing data if id != null
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }
}
