package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    ProductService productService;

    @GetMapping("/GetProductAll/{page}")
    public List<ProductResponse> GetProductAll(@PathVariable  int page){
        return productService.getProductsAll(page);

    }

    @GetMapping("/GetProductByName/{productName}/{page}")

    public List<ProductResponse> GetProductByName(@PathVariable String productName,@PathVariable  int page){
        return productService.getProductsByName(productName,page);

    }

    @GetMapping("/GetProductByName/{productName}")
    public List<ProductResponse> GetProductByName(@PathVariable String productName){
        int PAGE=1;
        return productService.getProductsByName(productName,PAGE);

    }

    @GetMapping("/GetProductById/{productId}")
    public  ProductResponse  GetProductById(@PathVariable int productId){
        return productService.getProductById(productId);

    }


}
