package com.janawat.ecommerce.product;

import com.janawat.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController1 {

    @Autowired
    ProductService productService;


    @GetMapping("/xproducts")
    public ResponseEntity<List<Product>> getProductAll() {

        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);

    }



}
