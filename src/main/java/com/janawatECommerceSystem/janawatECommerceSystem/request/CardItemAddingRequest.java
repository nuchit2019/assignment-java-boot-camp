package com.janawatECommerceSystem.janawatECommerceSystem.request;

import com.janawatECommerceSystem.janawatECommerceSystem.models.CartItem;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

public class CardItemAddingRequest {
    private int productId;
    private int quantity;

    public CardItemAddingRequest() {
    }

    public CardItemAddingRequest(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String ConvertToJsonString() {
        JSONObject json = new JSONObject();
        try {
            json.put("productId", productId);
            json.put("quantity", quantity);
        } catch (JSONException ex) {
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
