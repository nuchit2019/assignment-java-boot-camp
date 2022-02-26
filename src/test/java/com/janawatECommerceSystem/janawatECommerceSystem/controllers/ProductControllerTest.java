package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janawatECommerceSystem.janawatECommerceSystem.models.Product;
import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.ProductRepository;
import com.janawatECommerceSystem.janawatECommerceSystem.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Mock
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private List<Product> lsProduct;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("ค้นหาสินค้าไม่มี ต้องได้ StatusCode = 400")
    void getProductByName_StatusCode() throws Exception {

        String url = "http://localhost:" + randomServerPort + "/GetProductByName/ADIDAS";

        String PRODUCT_NAME = "testing";
        int expected = 400;


        ResponseEntity responseEntity = testRestTemplate.getForEntity(url + "/" + PRODUCT_NAME, String.class);
        assertEquals(expected, responseEntity.getStatusCode().value());
    }

    @Test
    @DisplayName("ส่งชื่อสินค้า ADIDAS_123 ต้องได้ ProductName = ADIDAS_123")
    void getProductByName1() throws Exception {

        String PRODUCT_NAME = "ADIDAS_123";
        String expected = PRODUCT_NAME;
        int PRODUCT_ID = 1;


        final String baseUrl = "http://localhost:" + randomServerPort + "/GetProductByName1/" + PRODUCT_NAME;
        URI uri = new URI(baseUrl);

        System.out.println("baseUrl= " + baseUrl);
        //Act========================================================

        ResponseEntity<ProductResponse> response = testRestTemplate.getForEntity(uri, ProductResponse.class);
        assertEquals(expected, response.getBody().getProductName());
    }


    @Test
    @DisplayName("Call /GetProductById/2  แล้วจะต้องได้ response ไม่เป็น null")
    void getProductById_ResponseNotNull() throws URISyntaxException {


        int expected = 2;
        int PRODUCT_ID = 2;
        int PAGE_NUMBER = 2;

        final String baseUrl = "http://localhost:" + randomServerPort + "/GetProductById/" + PRODUCT_ID;
        URI uri = new URI(baseUrl);

        // when
        ResponseEntity<ProductResponse> response = testRestTemplate.getForEntity(uri, ProductResponse.class);

        // then
        assertNotNull(response);


    }

    @Test
    @DisplayName("Call /GetProductById/2  แล้วจะต้องได้ HttpStatus.OK")
    void getProductById_HttpStatusOK() throws URISyntaxException {


        int expected = 2;
        int PRODUCT_ID = 2;
        int PAGE_NUMBER = 2;

        String baseUrl = "http://localhost:" + randomServerPort + "/GetProductById/" + PRODUCT_ID;
        URI uri = new URI(baseUrl);

        ResponseEntity<ProductResponse> response = testRestTemplate.getForEntity(uri, ProductResponse.class);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());


    }

    @Test
    @DisplayName("Call /GetProductById/2  แล้วจะต้องได้ ข้อมูลของ ProductId 2 ")
    void getProductById_2_Return_ProductId_2() throws URISyntaxException {


        int expected = 2;
        int PRODUCT_ID = 2;
        int PAGE_NUMBER = 2;

        final String baseUrl = "http://localhost:" + randomServerPort + "/GetProductById/" + PRODUCT_ID;
        URI uri = new URI(baseUrl);
        ResponseEntity<ProductResponse> response = testRestTemplate.getForEntity(uri, ProductResponse.class);

        // then
        assertEquals(expected, response.getBody().getId());


    }

}