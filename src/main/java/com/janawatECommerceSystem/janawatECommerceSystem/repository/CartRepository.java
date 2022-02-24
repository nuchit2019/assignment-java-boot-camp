package com.janawatECommerceSystem.janawatECommerceSystem.repository;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository
        extends JpaRepository<Cart, String> {
}
