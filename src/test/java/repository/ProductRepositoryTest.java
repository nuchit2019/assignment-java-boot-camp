package repository;

import com.janawat.ecommerce.model.Product;
import com.janawat.ecommerce.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;


    @Test
    @DisplayName("ค้นหา รหัสชื่อสินค้า = 1 จะต้องได้ ข้อมูลสินค้าที่มีรหัส 1")
    void findById() {
        Product product = productRepository.findById(1).get();
        Assertions.assertThat(product.getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("ค้นหา ชื่อสินค้าที่มีคำว่า \"ABCD\" จะต้องได้ จำนวนข้อมูล มากกว่า 0 เร็กคอร์ด")
    void findByProductNameContains() {

        Pageable pageable = PageRequest.of(1, 5);
        Page<Product> product = productRepository.findByProductNameContains("ABCD",pageable);
        Assertions.assertThat(product.getSize()).isGreaterThan(0);

    }

}