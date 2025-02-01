package com.trial.spring_security.service;

import java.util.List;

import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import com.trial.spring_security.domain.Product;

@Service
public class ProductService {

    @PreFilter("filterObject.owner == authentication.name")
    public List<Product> sellProducts(List<Product> products) {
        return products;
    }

}
