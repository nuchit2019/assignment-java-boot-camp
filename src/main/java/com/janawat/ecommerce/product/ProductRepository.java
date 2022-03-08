package com.janawat.ecommerce.product;

import com.janawat.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id);
    Page<Product> findByProductNameContains(String productName, Pageable pageable);
    Optional<Product> findByProductName(String productName);
}
