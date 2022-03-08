package com.janawat.ecommerce.cart;

import com.janawat.ecommerce.JsonConvertible;
import org.json.JSONException;
import org.json.JSONObject;


public class CartPaymentMethodRequest implements JsonConvertible {
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

    @Override
    public String toJsonString() {
        JSONObject json = new JSONObject();
        try {
            json.put("paymentMethodId", paymentMethodId);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return json.toString();
    }


}
