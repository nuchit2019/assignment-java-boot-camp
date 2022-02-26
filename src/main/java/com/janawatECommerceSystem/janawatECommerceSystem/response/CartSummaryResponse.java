package com.janawatECommerceSystem.janawatECommerceSystem.response;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Cart;
import com.janawatECommerceSystem.janawatECommerceSystem.models.CartItem;
import com.janawatECommerceSystem.janawatECommerceSystem.models.Product;
import com.janawatECommerceSystem.janawatECommerceSystem.services.AddressService;
import com.janawatECommerceSystem.janawatECommerceSystem.services.PaymentService;
import com.janawatECommerceSystem.janawatECommerceSystem.services.ProductService;

import java.util.ArrayList;

public class CartSummaryResponse {
    private ArrayList<CartItemResponse> items;
    private Double totalPrice;
    private String address;
    private String cardNumber;

    public CartSummaryResponse() {
        items = new ArrayList<>();
    }

    public static CartSummaryResponse fromCart(
            PaymentService paymentService,
            AddressService addressService,
            ProductService productService,
            Cart cart) {

        CartSummaryResponse response = new CartSummaryResponse();
        Double totalPrice = 0.0;

        for (CartItem item : cart.getItems()) {
            Product product = productService.getProduct(item.getProductId());
            response.addItem(CartItemResponse.ofProduct(product, item.getQuantity()));
            totalPrice += product.getPrice() * item.getQuantity();
        }

        response.setTotalPrice(totalPrice);

        if (cart.getAddressId() != null) {
            //response.setAddress(addressService.getAddress(cart.getAddressId()).getAddress());
            response.setAddress(addressService.getAddress(cart.getAddressId()).getFullAddress());
        }

        if (cart.getPaymentId() != null) {
            response.setCardNumber(  paymentService.getPaymentMethod( cart.getPaymentId()).getCardNumber());

        }

        return response;
    }

    public ArrayList<CartItemResponse> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItemResponse> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private void addItem(CartItemResponse cartItemResponse) {
        items.add(cartItemResponse);
    }

}
