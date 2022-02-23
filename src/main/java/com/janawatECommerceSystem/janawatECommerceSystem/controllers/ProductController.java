package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/GetProductByName/{productName}")
    public List<ProductResponse> GetProductByName(@PathVariable String productName){
        return productService.getProductsByName(productName);

    }

    @GetMapping("/GetProductById/{productId}")
    public  ProductResponse  GetProductById(@PathVariable int productId){
        return productService.getProductById(productId);

    }


}
