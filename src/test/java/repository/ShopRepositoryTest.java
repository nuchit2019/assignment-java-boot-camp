package repository;

import com.janawat.ecommerce.model.Shop;
import com.janawat.ecommerce.product.ShopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShopRepositoryTest {
    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setup() {
        Shop shop = new Shop(
                1,
                "ShopTest1",
                "",
                "กำแพงเพชร",
                "",
                "",
                "ACTIVE", new Date(),
                null);
        entityManager.persist(shop);
    }

    @Test
    @DisplayName("FindById ส่งรหัส Shop = 1 ต้องได้ shop ไม่เป็น null")
    public void testFindByIdNotNull(){
        String expected = "ShopTest12";

        Shop shop = shopRepository.findById(1).get();
        assertNotNull(shop);

    }

    @Test
    @DisplayName("FindById ส่งรหัส Shop = 1 ต้องได้ ชื่อ ShopTest1")
    public void testFindById(){
        String expected = "ShopTest1";

        Shop shop = shopRepository.findById(1).get();
        assertEquals(expected,shop.getName());
    }
}