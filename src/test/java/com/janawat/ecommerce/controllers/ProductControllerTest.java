package com.janawat.ecommerce.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janawat.ecommerce.model.Product;
import com.janawat.ecommerce.model.ProductResponse;
import com.janawat.ecommerce.product.ProductRepository;
import com.janawat.ecommerce.product.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProductController.class)
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest

//@WebMvcTest(controllers = ProductController.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    int randomServerPort;

//    @MockBean
//    MockMvc mockMvc;


    @Autowired
    private TestRestTemplate testRestTemplate;


    @MockBean
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
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

        String url = "http://localhost:" + randomServerPort + "/products/ADIDAS";

        String PRODUCT_NAME = "testing";
        int expected = 400;


        ResponseEntity responseEntity = testRestTemplate.getForEntity(url + "/" + PRODUCT_NAME, String.class);
        assertEquals(expected, responseEntity.getStatusCode().value());
    }

    @Test
    @DisplayName("ส่งชื่อสินค้า ADIDAS_123 ต้องได้ ProductName = ADIDAS_123")
    void getProductByName1() throws Exception {

        String expected ="ADIDAS VS Set รองเท้าลำลองผู้ชาย";
        String url = "http://localhost:" + randomServerPort + "/products/ADIDAS";

        Product product = new  Product(1,
                "ADIDAS VS Set รองเท้าลำลองผู้ชาย",
                "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT",
                750.0, 50.0, "2022-3-15", 0, 1, 5,
                "/1.jpg",
                new String[]{"/1.jpg","/2.jpg","/3.jpg","/4.jpg","/5.jpg"},
                1, 2, "ACTIVE", new Date(), null,
                new String[]{"36", "38", "40", "42", "44", "45", "50"});

        PageRequest paging = PageRequest.of(1, 10);
        List<Product> products = Arrays.asList(product);
        Page<Product> productPage = new PageImpl<>(products, paging, products.size());

        given(productService.findByProductNameContains("ADIDAS",1))
                .willReturn(productPage);

        ResponseEntity<Product> productResponse = testRestTemplate
                .getForEntity(url, Product.class);

        //assertEquals(null,productResponse.getBody());
        assertThat(productResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(productResponse.getBody().equals(product));


        //assertEquals(productResponse.getBody().getProductName(),product.getProductName());
        assertEquals(expected,product.getProductName());


    }

    ////////////////////////////

    // given
    @Test
    @DisplayName("ส่งรหัสสินค้า 1 ต้องได้ HttpStatus.OK")
    void productServicefindById1() {

        String url = "http://localhost:" + randomServerPort + "/product/1";

        var product = new Product(1, "ADIDAS VS Set รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 750.0, 50.0, "2022-3-15", 0, 1, 5, "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/5.jpg"}, 1, 2, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"});


        given(productService.findById(1))
                .willReturn(Optional.of(product));

        // when
        ResponseEntity<Product> superHeroResponse = testRestTemplate
                .getForEntity(url, Product.class);

        // then
        assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(superHeroResponse.getBody().equals(product));

    }

    @Test
    @DisplayName("ส่งรหัสสินค้า 1 ต้องได้ Body เท่ากับ อ็อบเจ็กต์ product")
    void productServicefindById2() {

        String url = "http://localhost:" + randomServerPort + "/product/1";

        var product = new Product(1, "ADIDAS VS Set รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 750.0, 50.0, "2022-3-15", 0, 1, 5, "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/5.jpg"}, 1, 2, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"});


        given(productService.findById(1))
                .willReturn(Optional.of(product));

        // when
        ResponseEntity<Product> superHeroResponse = testRestTemplate
                .getForEntity(url, Product.class);

        // then
        assertThat(superHeroResponse.getBody().equals(product));

    }

    /////////////////////////////

    @Test
    @DisplayName("Call /GetProductById/2  แล้วจะต้องได้ response ไม่เป็น null")
    void getProductById_ResponseNotNull() throws URISyntaxException {


        int expected = 2;
        int PRODUCT_ID = 2;
        int PAGE_NUMBER = 2;

        final String baseUrl = "http://localhost:" + randomServerPort + "/product/" + PRODUCT_ID;
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

        String baseUrl = "http://localhost:" + randomServerPort + "/product/" + PRODUCT_ID;
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

        final String baseUrl = "http://localhost:" + randomServerPort + "/product/" + PRODUCT_ID;
        URI uri = new URI(baseUrl);
        ResponseEntity<ProductResponse> response = testRestTemplate.getForEntity(uri, ProductResponse.class);

        // then
        assertEquals(expected, response.getBody().getId());


    }

}