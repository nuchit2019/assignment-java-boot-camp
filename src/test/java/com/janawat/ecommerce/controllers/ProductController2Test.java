package com.janawat.ecommerce.controllers;

import com.janawat.ecommerce.product.ProductController;
import com.janawat.ecommerce.product.ProductRepository;
import com.janawat.ecommerce.product.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(ProductController.class)
class ProductController2Test {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;


    @Test
    @DisplayName("ค้นหาสินค้าไม่มี ต้องได้ StatusCode = 400")
    void getProductByName_StatusCode() throws Exception {

       // Mockito.when(productService.findByProductNameContains())

    }

}