package com.janawat.ecommerce.controllers;

import com.janawat.ecommerce.product.ProductController1;
import com.janawat.ecommerce.product.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//@SpringBootTest(
//        classes = ProductController1.class,
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController1.class)
class ProductController1Test {


    @MockBean
    ProductService productService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getProductAll() throws Exception{

//        // given
//        List<Product> lsProduct = new ArrayList<>();
//        lsProduct.add(new Product(1, "ADIDAS VS Set รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 750.0, 50.0, "2022-3-15", 0, 1, 5, "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/5.jpg"}, 1, 2, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
//        lsProduct.add(new Product(2, "ADIDAS Lite Racer 2.0 รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 850.0, 50.0, "2022-4-15", 0, 2, 15, "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/14/006/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
//        lsProduct.add(new Product(3, "ADIDAS Lite Racer RBN 2.0 รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1100.0, 25.0, "2022-5-15", 0, 3, 20, "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/34/038/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
//        lsProduct.add(new Product(4, "ADIDAS Questar Flow NXT รองเท้าลำลองผู้ชาย", "พรองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1380.0, 30.0, "2022-6-25", 1, 4, 25, "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/87/719/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/5.jpg"}, 2, 2, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
//        lsProduct.add(new Product(5, "ADIDAS รองเท้ากีฬา รุ่น Advantage Base - สี Core Black", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
//
//
//        Mockito.when(productService.findAll()).thenReturn(lsProduct);
//
//        mockMvc.perform(get("/xproducts"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(jsonPath("$[0].productName", Matchers.is("ADIDAS")));

    }
}