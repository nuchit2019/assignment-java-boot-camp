package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Product;
import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
public class ProductController1 {

    @Autowired
    private ProductService productService;

 /*
    @GetMapping("/getProducts_test1/{productName}")
    public ResponseEntity<Product> getProducts1(@PathVariable String productName) {
        Optional<Product> product = productService.getProductsByName(productName);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/getProducts_test2")
    public ResponseEntity<List<ProductResponse>> getProducts2() {
        List<ProductResponse> product = productService.getProductsAll(1);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @GetMapping("/GetProductByName_test/{productName}/{page}")
    public ResponseEntity<List<ProductResponse>> GetProductByName(@PathVariable String productName, @PathVariable int page) {
        return new ResponseEntity<>(productService.getProductsByName(productName, page), HttpStatus.OK);

    }

    @GetMapping("/GetProductByName_test/{productName}")
    public ResponseEntity<List<ProductResponse>> GetProductByNameDefault(@PathVariable String productName) {
        int PAGE = 1;
        return new ResponseEntity<>(productService.getProductsByName(productName, PAGE), HttpStatus.OK);

    }

    @GetMapping("/GetProductByName_test1/{productName}")
    public  List<ProductResponse>  GetProductByNameDefault1(@PathVariable String productName) {
        int PAGE = 1;
        return   productService.getProductsByName(productName, PAGE);

    }


    @GetMapping("/GetProductById_test/{productId}")
    public ResponseEntity GetProductById(@PathVariable int productId) {
        return new ResponseEntity(productService.getProductById(productId), HttpStatus.OK);

    }

*/


}
