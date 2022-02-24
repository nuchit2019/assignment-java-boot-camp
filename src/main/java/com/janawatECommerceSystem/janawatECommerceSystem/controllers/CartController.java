package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.request.CardItemAddingRequest;
import com.janawatECommerceSystem.janawatECommerceSystem.request.CartPaymentMethodRequest;
import com.janawatECommerceSystem.janawatECommerceSystem.request.SelectCartAddressRequest;
import com.janawatECommerceSystem.janawatECommerceSystem.response.CarItemAddedResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.response.CartItemsResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.response.CartSummaryResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserToken userToken;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PaymentService paymentService;
    private org.springframework.http.HttpStatus HttpStatus;

    @PostMapping(value = "/cart/items",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CarItemAddedResponse AddCartItem(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody CardItemAddingRequest cardRequest) {

        /* System.out.println("call.../cart/items"); */

        cartService.addItemCart(userToken.decodeToken(token), cardRequest.toCartItem());

        return new CarItemAddedResponse("OK");

    }


    @GetMapping("/cart/items")
    public CartItemsResponse getCartItem(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return CartItemsResponse.fromCart(
                productService,
                cartService.getCart(userToken.decodeToken(token)));
    }

    @GetMapping("/cart")
    public CartSummaryResponse summaryCard(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return CartSummaryResponse.fromCart(
                paymentService,
                addressService,
                productService,
                cartService.getCart(userToken.decodeToken(token)));


    }

    @DeleteMapping("/cart")
    public void clearCart(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        cartService.clearCart(userToken.decodeToken(token));
    }

    @PutMapping("/cart/address")
    public void setCardAddress(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody SelectCartAddressRequest addressRequest) {
        String username = userToken.decodeToken(token);
        if (addressService.isMyAddress(username, addressRequest.getAddressId())) {
            cartService.setCartAddress(username, addressRequest.getAddressId());
        }
    }

    @PutMapping("/cart/paymentMethod")
    public void setPaymentMethod(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody CartPaymentMethodRequest cartRequest) {
        String username = userToken.decodeToken(token);
        if (paymentService.isMyPaymentMethod(username, cartRequest.getPaymentMethodId())) {
            cartService.setPaymentMethod(username, cartRequest.getPaymentMethodId());
        }

    }
}
