package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    ProductService productService;

    @GetMapping("/GetProductAll")
    public List<ProductResponse> GetProductAll(){
        return productService.getProductsAll();

    }
}
