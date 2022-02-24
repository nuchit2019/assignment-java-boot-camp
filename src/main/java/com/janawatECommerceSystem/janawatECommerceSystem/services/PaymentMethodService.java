package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.models.PaymentMethod;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.PaymentMethodRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;

@Server
public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod getPaymentMethod(int paymentMethodId) {
        return paymentMethodRepository.findById(paymentMethodId).orElse(null);
    }

    public boolean isMyPaymentMethod(String username, int paymentMethodId) {
        return paymentMethodRepository.findById(paymentMethodId)
                .map(paymentMethod -> paymentMethod.getOwner().equals(username))
                .orElse(false);
    }


}
