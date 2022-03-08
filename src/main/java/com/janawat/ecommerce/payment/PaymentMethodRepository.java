package com.janawat.ecommerce.payment;

import com.janawat.ecommerce.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository
        extends JpaRepository<PaymentMethod, Integer> {
}
