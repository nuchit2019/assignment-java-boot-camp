package com.janawat.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.ArrayList;

@Entity
public class Cart {
    @Id
    private String username;
    @Lob
    private ArrayList<CartItem> items;
    private Integer addressId;
    private Integer paymentId;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(String username) {
        this.username = username;
        this.items = new ArrayList<>();
    }

    public Cart(String username, ArrayList<CartItem> items, int addressId, int paymentId) {
        this.username = username;
        this.items = new ArrayList<>();
        this.addressId = addressId;
        this.paymentId = paymentId;
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
