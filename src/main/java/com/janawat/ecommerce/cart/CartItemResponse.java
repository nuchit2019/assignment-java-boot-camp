package com.janawat.ecommerce.cart;

import com.janawat.ecommerce.JsonConvertible;
import com.janawat.ecommerce.model.Product;
import org.json.JSONException;
import org.json.JSONObject;


public class CartItemResponse implements JsonConvertible {
    private int productId;
    private String productName;
    private int quantity;
    private Double pricePerUnit;

    public CartItemResponse() {
    }

    public CartItemResponse(int productId,
                            String productName,
                            int quantity,
                            Double pricePerUnit) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public static CartItemResponse ofProduct(Product product, int quantity) {




        return new CartItemResponse(
                product.getId(),
                product.getProductName(),
                quantity,
                product.getPrice());

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
