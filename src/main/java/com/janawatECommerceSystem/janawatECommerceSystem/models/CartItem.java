package com.janawatECommerceSystem.janawatECommerceSystem.models;

import java.io.Serializable;

public class CartItem  implements Serializable {
    private int productId;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
