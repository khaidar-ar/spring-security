package com.trial.spring_security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trial.spring_security.domain.Product;
import com.trial.spring_security.repository.ProductRepository;
import com.trial.spring_security.service.CustomService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RestController
public class HelloController {

    private final CustomService customService;
    private final ProductRepository productRepository;

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

    @GetMapping("/products/{txt}")
    public List<Product> sellProduct(@PathVariable String txt) {
        return productRepository.findByNameContains(txt);
    }

}
