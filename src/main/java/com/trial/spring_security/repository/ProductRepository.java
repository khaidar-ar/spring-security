package com.trial.spring_security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostFilter;

import com.trial.spring_security.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @PostFilter("filterObject.owner == authentication.name")
    // deprecated
    // because SecurityEvaluationContextExtension class is no longer used in spring
    // 3.x.x
    // @Query("""
    // SELECT p from Product WHERE p.name LIKE %:txt%
    // AND p.owner = ?#{authentication.name}
    // """)
    List<Product> findByNameContains(String txt);

}
