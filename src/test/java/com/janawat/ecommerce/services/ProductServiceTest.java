package com.janawat.ecommerce.services;

import com.janawat.ecommerce.model.CartItem;
import com.janawat.ecommerce.model.Product;
import com.janawat.ecommerce.product.ProductRepository;
import com.janawat.ecommerce.product.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductService productService;


    @Test
    @DisplayName("สินค้า มีจำนวน 15 ชิ้น หยิบใส่ตะกร้า 2 ชิ้น ต้องเหลือ 13 ชิ้น")
    void adjustProduct() {
        //Arrange
        int expected = 13;

        Product product = new Product();
        product.setId(1);
        product.setProductName("testing");
        product.setPrice(500.0);

        product.setInStock(15);//<<================= InStock

        CartItem cartItem = new CartItem(product.getId(), 2);
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        //Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        int result = productService.adjustProduct(cartItem.getProductId(),cartItem.getQuantity());

        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("สินค้า มีจำนวน 2 ชิ้น หยิบใส่ตะกร้า 1 ชิ้น ต้องสามารถซื้อได้")
    void isInstokCanOrder() {
        //Arrange
        boolean expected = true;

        Product product = new Product();
        product.setId(1);
        product.setProductName("testing");
        product.setPrice(500.0);

        product.setInStock(2);//<<============================================================= InStock 2 ชิ้น

        CartItem cartItem = new CartItem(product.getId(), 1); //<======================= หยิบใสาตะกร้า 1 ชิ้น
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        //Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        boolean result = productService.isInstokCanOrder(cartItem.getProductId(),cartItem.getQuantity());

        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("สินค้า มีจำนวน 2 ชิ้น หยิบใส่ตะกร้า 3 ชิ้น ต้อง...ไม่สามารถซื้อได้")
    void isInstokNoCanOrder() {
        //Arrange
        boolean expected = false;

        Product product = new Product();
        product.setId(1);
        product.setProductName("testing");
        product.setPrice(500.0);

        product.setInStock(2);//<<============================================================= InStock 2 ชิ้น

        CartItem cartItem = new CartItem(product.getId(), 3); //<======================= หยิบใสาตะกร้า 1 ชิ้น
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        //Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        boolean result = productService.isInstokCanOrder(cartItem.getProductId(),cartItem.getQuantity());

        //Assert
        assertEquals(expected, result);
    }


    @Test
    @DisplayName("ค้นหา รหัสสินค้า = 1  ต้องได้ รหัสสินค้า 1 ")
    void getProductById() {

//        //Arrange
//        int expected = 1;
//
//        Product product = new Product();
//        product.setId(1);
//        product.setProductName("testing");
//        product.setPrice(500.0);
//        product.setDiscountPercent(30.0);
//        product.setProductModel(new ProductModel());
//        product.setShop(new Shop());
//        product.setBrand(new Brand());
//        product.setProductReviews(new ArrayList<ProductReview>());
//
//
//        when(productRepository.findById(1)).thenReturn(Optional.of(product));
//        //Act
//        ProductService productService = new ProductService();
//        productService.setProductRepository(productRepository);
//
//        int result = productService.findById(1).getId();
//        String resultName = productService.findById(1).getProductName();
//
//        //Assert
//        assertEquals(expected, result);

    }

    @Test
    @DisplayName("ค้นหา ชื่อสินค้า = testing ต้องได้ ชื่อสินค้า testing ")
    void getProductsFindByName() {

//        //Arrange
//        String expected1 = "testing";
//
//        Product product = new Product();
//        product.setId(1);
//        product.setProductName("testing");
//        product.setPrice(500.0);
//        product.setDiscountPercent(30.0);
//        product.setProductModel(new ProductModel());
//        product.setShop(new Shop());
//        product.setBrand(new Brand());
//        product.setProductReviews(new ArrayList<ProductReview>());
//
//        when(productRepository.findById(1)).thenReturn(Optional.of(product));
//        //Act
//        ProductService productService = new ProductService();
//        productService.setProductRepository(productRepository);
//
//        int result = productService.findById(1).getId();
//        String resultName = productService.findById(1).getProductName();
//
//        //Assert
//        assertEquals(expected1, resultName);
    }



}