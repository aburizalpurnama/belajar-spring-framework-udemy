package com.rizal.springdemo.crm.dao;

import com.rizal.springdemo.crm.entity.Customer;
import com.rizal.springdemo.crm.util.SortUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    private Logger logger = Logger.getLogger(getClass().getName());

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

        logger.info("running no args method");

        return listCustomers;
    }

    @Override
    public List<Customer> getCustomers(int sortField) {
        Session session = sessionFactory.getCurrentSession();

        // get field name
        String fieldName = null;

        switch (sortField){
            case SortUtil.FIRST_NAME:
                fieldName = "firstName";
                break;
            case SortUtil.LAST_NAME:
                fieldName = "lastName";
                break;
            case SortUtil.EMAIL:
                fieldName = "email";
                break;
            default:
                // if sort value is nothing mathes, set to lastName
                fieldName = "lastName";
        }

        // create query
        String queryString = "from Customer order by " + sortField;
        Query<Customer> query = session.createQuery(queryString, Customer.class);

        logger.info("running args method, sort value : " + sortField);

        // execute query to get result list and return it
        return query.getResultList();
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

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        // #1 cara pertama (dengan membuat query)
        Query query = session.createQuery("delete from Customer where id=:customerId");

        query.setParameter("customerId", id);

        query.executeUpdate();

        // #2 cara kedua dengan getData terlebih dathulu, kemudian delete data tersebut.
//        // get customer
//        Customer customer = session.get(Customer.class, id);
//
//        // delete customer
//        session.delete(customer);

    }

    @Override
    public List<Customer> seachCustomerByName(@RequestParam("") String searchName) {
        Session session = sessionFactory.getCurrentSession();

        Query query = null;

        // only search by name if searchName is not null & not empty

        if (searchName != null && (searchName.trim().length() > 0)){
            // search for firstName of lastName (case insensitif)
            query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        } else {
            // searchName is empty, so just get all data customer
            query = session.createQuery("from Customer", Customer.class);
        }

        // execute query
        List<Customer> customers = query.getResultList();

        return customers;
    }
}
