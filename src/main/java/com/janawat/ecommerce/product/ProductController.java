package com.janawat.ecommerce.product;

import com.janawat.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{productName}/{page}")
    public Page<Product> GetProductByName(@PathVariable String productName, @PathVariable int page) {
        return productService
                .findByProductNameContains(productName, page);

    }

    @GetMapping("/products/{productName}")
    public Page<Product> GetProductByNameDefault(@PathVariable String productName) {
        int PAGE = 1;
        return productService
                .findByProductNameContains(productName, PAGE);

    }

    @GetMapping("/product/{productId}")
    public Optional<Product> GetProductById(@PathVariable int productId) {
        return productService
                .findById(productId);

    }


}
