package com.trial.spring_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trial.spring_security.domain.Product;
import com.trial.spring_security.service.CustomService;
import com.trial.spring_security.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RestController
public class HelloController {

    private final CustomService customService;
    private final ProductService productService;

    @GetMapping("/hello")
    public String hello() {
        log.info("request from root");
        return "========================\n" + customService.getDetails();
    }

    @GetMapping("/jobs/{name}")
    public List<String> job(@PathVariable String name) {
        log.info("request from job");
        return customService.getJobs(name);
    }

    @GetMapping("/products")
    public List<Product> sellProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("book", "john"));
        products.add(new Product("beer", "paul"));
        products.add(new Product("car", "john"));
        return productService.sellProducts(products);
    }

}
