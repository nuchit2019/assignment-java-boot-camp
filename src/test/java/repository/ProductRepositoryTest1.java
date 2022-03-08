package repository;

import com.janawat.ecommerce.model.CartItem;
import com.janawat.ecommerce.model.Product;
import com.janawat.ecommerce.model.ProductModel;
import com.janawat.ecommerce.product.ProductRepository;
import com.janawat.ecommerce.product.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductRepositoryTest1 {

    @Mock
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    Product newProduct;
    List<Product> lsProduct;
    Page<Product> pagedProduct;

    @BeforeEach
    void setup() {


        String imgUrl = "http://supersports-media-live-th.s3.amazonaws.com/product/21/205";

        ProductModel productModel = new ProductModel(1, "Beluga", "ACTIVE", new Date(), null);
        newProduct = new Product(
                1,
                "ADIDAS_Test",
                "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT",
                750.0, 50.0,
                "2022-3-15",
                0,
                1,
                5,
                imgUrl + "/1.jpg",
                new String[]{imgUrl + "/1.jpg",
                        imgUrl + "/2.jpg",
                        imgUrl + "/3.jpg",
                        imgUrl + "/4.jpg",
                        imgUrl + "/5.jpg"},
                1,
                2,
                "ACTIVE",
                new Date(),
                null,
                new String[]{"36", "38", "40", "42", "44", "45", "50"}
        );

        Optional<Product> product = Optional.of(newProduct);
        Mockito.when(productService.findById(1))
                .thenReturn(product);


        lsProduct = new ArrayList<>();

        lsProduct.add(new Product(1, "ADIDAS VS Set รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 750.0, 50.0, "2022-3-15", 0, 1, 5, "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/5.jpg"}, 1, 2, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(2, "ADIDAS Lite Racer 2.0 รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 850.0, 50.0, "2022-4-15", 0, 2, 15, "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/14/006/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(3, "ADIDAS Lite Racer RBN 2.0 รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1100.0, 25.0, "2022-5-15", 0, 3, 20, "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/34/038/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(4, "ADIDAS Questar Flow NXT รองเท้าลำลองผู้ชาย", "พรองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1380.0, 30.0, "2022-6-25", 1, 4, 25, "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/87/719/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/5.jpg"}, 2, 2, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(5, "ADIDAS รองเท้ากีฬา รุ่น Advantage Base - สี Core Black", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));


        pagedProduct = new PageImpl(lsProduct);
        Mockito.when(productService.findByProductNameContains("ADIDAS", 1))
                .thenReturn(pagedProduct);

        productService.setProductRepository(productRepository);

    }


    @Test
    @DisplayName("ค้นหา รหัสชื่อสินค้า = 1 จะต้องได้ ข้อมูลสินค้า ไม่เป็น NULL")
    void findById1() {

        String expected = "ADIDAS_Test";
        Optional<Product> product = productService.findById(1);
        assertNotNull(product);

    }

    @Test
    @DisplayName("ค้นหา รหัสชื่อสินค้า = 1 จะต้องได้ ข้อมูลสินค้าชื่อสินค้า = ADIDAS_Test")
    void findById2() {

        String expected = "ADIDAS_Test";
        Optional<Product> product = productService.findById(1);
        assertEquals(expected, product.get().getProductName());

    }

    @Test
    @DisplayName("ค้นหา ชื่อสินค้า = ADIDAS จะต้องได้ ข้อมูลสินค้า จำนวน 5 ชิ้น")
    void findByProductNameContains1() {

        String expected = "ADIDAS Test";
        Page<Product> product = productService.findByProductNameContains("ADIDAS", 1);
        int page = product.getSize();

        assertTrue(1 < page && page <= 5);

    }

    @Test
    @DisplayName("ค้นหา ชื่อสินค้า = ADIDAS จะต้องได้ ข้อมูลสินค้า จำนวน 5 หน้า")
    void findByProductNameContains2() {

        String expected = "ADIDAS Test";
        Page<Product> product = productService.findByProductNameContains("ADIDAS", 1);
        assertEquals(5, product.getSize());
    }

    @Test
    void isInstokCanOrder() {
        boolean expected = true;

        CartItem cartItem = new CartItem(1, 2);

        Mockito.when(productService.isInstokCanOrder(1,2))
                .thenReturn(true);


        boolean isInstokCanOrder = productService.isInstokCanOrder(1,2);
        assertEquals(expected, isInstokCanOrder);
    }

    @Test
    void adjustProduct() {
        Integer expected = 3;

        CartItem cartItem = new CartItem(1, 2);

        Mockito.when(productService.adjustProduct(1,2))
                .thenReturn(3);

        Integer isInstokCanOrder = productService.adjustProduct(1,2);
        assertEquals(expected, isInstokCanOrder);
    }

    @Test
    void findByProductName() {
    }
}