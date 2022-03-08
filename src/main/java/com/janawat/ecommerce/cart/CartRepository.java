package com.janawat.ecommerce.cart;

import com.janawat.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository
        extends JpaRepository<Cart, String> {
}
