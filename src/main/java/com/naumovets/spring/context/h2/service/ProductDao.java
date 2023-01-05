package com.naumovets.spring.context.h2.service;

import com.naumovets.spring.context.h2.model.Customer;
import com.naumovets.spring.context.h2.model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    List<Customer> getCustomersListById(Long id);
}
