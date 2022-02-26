package com.janawatECommerceSystem.janawatECommerceSystem.response;


public class CartItemAddedResponse {
    private String message;

    public CartItemAddedResponse() {
    }

    public CartItemAddedResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
