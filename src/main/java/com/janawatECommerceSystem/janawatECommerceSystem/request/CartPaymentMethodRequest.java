package com.janawatECommerceSystem.janawatECommerceSystem.request;

import com.fasterxml.jackson.core.JacksonException;
import org.json.JSONException;
import org.json.JSONObject;

public class CartPaymentMethodRequest {
    private Integer paymentMethodId;

    public CartPaymentMethodRequest() {
    }

    public CartPaymentMethodRequest(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String convertToJsonString() {
        JSONObject json = new JSONObject();
        try {
            json.put("paymentMethodId", paymentMethodId);
        } catch (JSONException e) {
            return null;
        }

        return json.toString();

    }
}
