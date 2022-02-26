package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.models.PaymentMethod;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    public PaymentMethod getPaymentMethod(int paymentMethodId) {
        return paymentMethodRepository
                .findById(paymentMethodId).orElse(null);
    }

    public boolean isMyPaymentMethod( String username, int paymentMethodId) {
        //sample isMyPaymentMethod
        return true;
    }

}
