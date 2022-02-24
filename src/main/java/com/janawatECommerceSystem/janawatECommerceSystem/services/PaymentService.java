package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.models.DefaultPaymentMethod;
import com.janawatECommerceSystem.janawatECommerceSystem.models.PaymentMethod;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.DefaultPaymentMethodRepository;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private DefaultPaymentMethodRepository defaultPaymentMethodRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

//    public PaymentMethod getMyDefaultPaymentMethod(String username) {
//        return defaultPaymentMethodRepository.findById(username)
//                .map(DefaultPaymentMethod::getPaymentMethod).orElse(null);
//    }
//
//    public void setMyDefaultPaymentMethod(String username, PaymentMethod paymentMethod) {
//        defaultPaymentMethodRepository.save(new DefaultPaymentMethod(username, paymentMethod));
//    }

    public PaymentMethod getPaymentMethod(int paymentMethodId) {
        return paymentMethodRepository
                .findById(paymentMethodId).orElse(null);
    }

    public boolean isMyPaymentMethod(
            String username,
            int paymentMethodId) {
//        return paymentMethodRepository.findById(paymentMethodId)
//                .map(paymentMethod->paymentMethod.getOwner().equals(username))
//                .orElse(false);
        return true;
    }

}
