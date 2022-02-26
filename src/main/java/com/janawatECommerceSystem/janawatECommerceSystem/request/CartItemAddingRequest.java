package com.janawatECommerceSystem.janawatECommerceSystem.request;

import com.janawatECommerceSystem.janawatECommerceSystem.JsonConvertible;
import com.janawatECommerceSystem.janawatECommerceSystem.models.CartItem;

import org.json.JSONException;
import org.json.JSONObject;

public class CartItemAddingRequest implements JsonConvertible {
    private int productId;
    private int quantity;

    public CartItemAddingRequest() {
    }

    public CartItemAddingRequest(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toJsonString() {
        JSONObject json = new JSONObject();
        try {
            json.put("productId", productId);
            json.put("quantity", quantity);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return json.toString();
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

    public CartItem toCartItem() {
        return new CartItem(productId, quantity);
    }
}
