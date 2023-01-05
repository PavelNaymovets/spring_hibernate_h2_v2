package com.naumovets.spring.context.h2.service;

import com.naumovets.spring.context.h2.model.Customer;
import com.naumovets.spring.context.h2.model.Product;
import com.naumovets.spring.context.h2.repository.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao{
    SessionFactoryUtils sessionFactory;

    public CustomerDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactory = sessionFactoryUtils;
    }

    @Override
    public Customer findById(Long id) {
        try(Session session = sessionFactory.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();

            return customer;
        }
    }

    @Override
    public List<Product> getProductsListById(Long id) {
        try(Session session = sessionFactory.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
//            System.out.println(customer.getProductsList());
            List<Product> products = customer.getProductsList();
            session.getTransaction().commit();

            return products;
        }
    }
}
