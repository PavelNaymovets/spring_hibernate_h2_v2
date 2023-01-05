package com.naumovets.spring.context.h2.service;

import com.naumovets.spring.context.h2.model.Customer;
import com.naumovets.spring.context.h2.model.Product;
import com.naumovets.spring.context.h2.repository.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao{
    SessionFactoryUtils sessionFactory;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactory = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try(Session session = sessionFactory.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();

            return product;
        }
    }

    @Override
    public List<Customer> getCustomersListById(Long id) {
        try(Session session = sessionFactory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            List<Customer> customers = product.getCustomersList();
            session.getTransaction().commit();

            return customers;
        }
    }
}
