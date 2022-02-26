package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Product;
import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController
{
    @Autowired
    ProductService productService;


    @GetMapping("/GetProductByName/{productName}/{page}")
    public List<ProductResponse> GetProductByName(@PathVariable String productName,@PathVariable  int page){
        return productService.getProductsByName(productName,page);

    }

    @GetMapping("/GetProductByName/{productName}")
    public List<ProductResponse> GetProductByNameDefault(@PathVariable String productName){
        int PAGE=1;
        return productService.getProductsByName(productName,PAGE);

    }

    @GetMapping("/GetProductByName1/{productName}")
    public ResponseEntity<Product> getProducts1(@PathVariable String productName) {
        Optional<Product> product = productService.getProductsByName(productName);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/GetProductById/{productId}")
    public  ProductResponse  GetProductById(@PathVariable int productId){
        return productService.getProductById(productId);

    }


}
