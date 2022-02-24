package com.janawatECommerceSystem.janawatECommerceSystem.repository;

import com.janawatECommerceSystem.janawatECommerceSystem.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository
        extends JpaRepository<PaymentMethod, Integer> {
}
