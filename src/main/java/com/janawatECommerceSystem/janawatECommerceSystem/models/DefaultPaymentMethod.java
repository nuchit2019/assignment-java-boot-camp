package com.janawatECommerceSystem.janawatECommerceSystem.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DefaultPaymentMethod {
    @Id
    private String username;
    @OneToOne(cascade = CascadeType.ALL)
    private PaymentMethod paymentMethod;

    public DefaultPaymentMethod() {
    }

    public DefaultPaymentMethod(String username, PaymentMethod paymentMethod) {
        this.username = username;
        this.paymentMethod = paymentMethod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
