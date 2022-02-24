package com.janawatECommerceSystem.janawatECommerceSystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentMethod {
    @Id
    private Integer id;
    private String owner;
    private String method;
    private String ownerName;
    private String cardNumber;
    private String expire;
    private String cvc;

    public PaymentMethod() {
    }

    public PaymentMethod(Integer id, String owner, String method, String ownerName, String cardNumber, String expire, String cvc) {
        this.id = id;
        this.owner = owner;
        this.method = method;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.expire = expire;
        this.cvc = cvc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String cardNumber() {
        return cardNumber;
    }

    public void setOwnerName(String cardNumber) {
        this.cardNumber = ownerName;
    }

    public String getCardNumber () {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getCvv() {
        return cvc;
    }

    public void setCvv(String cvc) {
        this.cvc = cvc;
    }
}
