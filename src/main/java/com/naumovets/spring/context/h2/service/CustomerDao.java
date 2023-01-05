package com.naumovets.spring.context.h2.service;

import com.naumovets.spring.context.h2.model.Customer;
import com.naumovets.spring.context.h2.model.Product;

import java.util.List;

public interface CustomerDao {
    Customer findById(Long id);
    List<Product> getProductsListById(Long id);
}
