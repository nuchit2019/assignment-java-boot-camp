package com.janawatECommerceSystem.janawatECommerceSystem.response;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Product;

public class CartItemResponse {
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

        System.out.println(" ========= :CartItemResponse: ========= ");
        System.out.println("product.getId(): " + product.getId());
        System.out.println("product.getId(): " + product.getId());
        System.out.println("product.getProductName(): " + product.getProductName());
        System.out.println("quantity: " + quantity);
        System.out.println(" product.getPrice(): " + product.getPrice());


        return new CartItemResponse(
                product.getId(),
                product.getProductName(),
                quantity,
                product.getPrice());

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
