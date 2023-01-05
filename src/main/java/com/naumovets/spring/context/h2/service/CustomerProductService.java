package com.naumovets.spring.context.h2.service;

import com.naumovets.spring.context.h2.model.Customer;
import com.naumovets.spring.context.h2.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerProductService {
    private CustomerDao customerDao;
    private ProductDao productDao;

    public CustomerProductService(CustomerDao customerDao, ProductDao productDao){
        this.customerDao = customerDao;
        this.productDao = productDao;
    }

    public List<Product> getCustomerProductsById(Long id) {
        return customerDao.getProductsListById(id);
    }

    public List<Customer> getProductCustomersById(Long id) {
        return productDao.getCustomersListById(id);
    }

    public Customer getCustomerById(Long id) {
        return customerDao.findById(id);
    }

    public Product getProductById(Long id) {
        return productDao.findById(id);
    }
}
