package com.janawat.ecommerce.services;

import com.janawat.ecommerce.model.PaymentMethod;
import com.janawat.ecommerce.payment.PaymentService;
import com.janawat.ecommerce.payment.PaymentMethodRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentMethodRepository paymentMethodRepository;


    @Test
    @DisplayName("ส่ง paymentMethodId = 1 จะต้องได้ paymentMethod = \"creditCard\"")
    public void getPaymentMethod() {

        String expected = "creditCard";

        PaymentMethod paymentMethod =
                new PaymentMethod(
                        1,
                        "NUCHIT",
                        "creditCard",
                        "Nuchit Atjanawat",
                        "5555444466667777",
                        "2024/12",
                        "555"
                );


        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentMethodRepository(paymentMethodRepository);


        when(paymentMethodRepository.findById(1)).thenReturn(Optional.of(paymentMethod));


        String result = paymentService.getPaymentMethod(1).getMethod();

        assertEquals(expected, result);
    }
}