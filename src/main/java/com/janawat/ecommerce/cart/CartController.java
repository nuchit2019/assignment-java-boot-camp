package com.janawat.ecommerce.cart;

import com.janawat.ecommerce.authen.UserToken;
import com.janawat.ecommerce.customer.AddressService;
import com.janawat.ecommerce.payment.PaymentService;
import com.janawat.ecommerce.product.ProductService;
import com.janawat.ecommerce.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<CartItemAddedResponse> AddCartItem(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody CartItemAddingRequest cardRequest) {


        cartService.addItemCart(userToken.decodeToken(token), cardRequest.toCartItem());

        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @GetMapping("/cart/items")
    public ResponseEntity<CartItemsResponse> getCartItem(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new ResponseEntity<>
                (CartItemsResponse.fromCart
                        (
                                productService,
                                cartService.getCart(userToken.decodeToken(token))
                        ), HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<CartSummaryResponse> summaryCard(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new ResponseEntity<>(CartSummaryResponse.fromCart(
                paymentService,
                addressService,
                productService,
                cartService.getCart(userToken.decodeToken(token)))
                , HttpStatus.OK);


    }

    @DeleteMapping("/cart")
    public ResponseEntity<Cart> clearCart(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        ResponseEntity responseEntity;
        cartService.clearCart(userToken.decodeToken(token));
        return new ResponseEntity<Cart>(HttpStatus.OK);
    }

    @PutMapping("/cart/address")
    public ResponseEntity setCardAddress( @RequestHeader(HttpHeaders.AUTHORIZATION) String token,  @RequestBody SelectCartAddressRequest addressRequest) {
        String username = userToken.decodeToken(token);
        if (addressService.isMyAddress(username, addressRequest.getAddressId())) {
            cartService.setCartAddress(username, addressRequest.getAddressId());
        }

        return  new ResponseEntity (HttpStatus.OK);
    }

    @PutMapping("/cart/payment")
    public ResponseEntity setPaymentMethod( @RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody CartPaymentMethodRequest cartRequest) {
        String username = userToken.decodeToken(token);
        if (paymentService.isMyPaymentMethod(username, cartRequest.getPaymentMethodId())) {
            cartService.setPaymentMethod(username, cartRequest.getPaymentMethodId());
        }

        return  new ResponseEntity (HttpStatus.OK);
    }
}
