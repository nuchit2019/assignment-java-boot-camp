package com.janawatECommerceSystem.janawatECommerceSystem.repository;

import com.janawatECommerceSystem.janawatECommerceSystem.models.DefaultPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultPaymentMethodRepository
        extends JpaRepository<DefaultPaymentMethod, String> {
}
