package com.janawat.ecommerce.controllers;

import com.janawat.ecommerce.RestConsumer;
import com.janawat.ecommerce.customer.AddressService;
import com.janawat.ecommerce.model.CartItem;
import com.janawat.ecommerce.cart.CartItemAddingRequest;
import com.janawat.ecommerce.cart.CartPaymentMethodRequest;
import com.janawat.ecommerce.cart.SelectCartAddressRequest;
import com.janawat.ecommerce.cart.CartItemAddedResponse;
import com.janawat.ecommerce.cart.CartService;
import com.janawat.ecommerce.payment.PaymentService;
import com.janawat.ecommerce.authen.UserToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartControllerTest {
    @MockBean
    UserToken userToken;

    @MockBean
    CartService cartService;

    @MockBean
    AddressService addressService;

    @MockBean
    PaymentService paymentService;

    @Autowired
    private RestConsumer testTemp;

    @LocalServerPort
    int randomServerPort;

    @Test
    @DisplayName("หยิบสินค้าลงตะกร้า โดย call /cart/items พร้อม user และ token เพิ่มสินค้าสำเร็จ จะต้อง ได้ statusCode = OK และ verify อ็บเจอ็กต์ 2 ก้อนต้องเท่ากัน")
    void addCartItem()  throws URISyntaxException {

        String sampleToken = "sampleToken";
        String username = "user1";

        int PRODUCT_ID = 1;
        int QYT = 2;

        String URL = "http://localhost:" + randomServerPort + "/cart/items";

        when(userToken.decodeToken(sampleToken)).thenReturn(username);
        CartItem cartItem = new CartItem(PRODUCT_ID, QYT);
        CartItemAddingRequest cartItemReq = new CartItemAddingRequest(PRODUCT_ID, QYT);
        HttpStatus statusCode = testTemp.postWithToken(URL, sampleToken, cartItemReq, CartItemAddedResponse.class)
                .getStatusCode();

        assert statusCode != null;
        verify(cartService).addItemCart(username, cartItem);
        assertEquals(HttpStatus.CREATED, statusCode);

    }


    @Test
    @DisplayName("การUpdate Shipping address โดย call /cart/address พร้อม user และ token การเพิ่มสินค้าสำเร็จ จะต้อง ได้ statusCode = OK และ verify อ็บเจอ็กต์ 2 ก้อนต้องเท่ากัน")
    void setCardAddress()  throws URISyntaxException {

        String sampleToken = "sampleToken";
        String username = "user1";

        String URL = "http://localhost:" + randomServerPort + "/cart/address";

        int ADDRESS_ID = 555;


        when(userToken.decodeToken(sampleToken)).thenReturn(username);
        when(addressService.isMyAddress(username, ADDRESS_ID)).thenReturn(true);

        SelectCartAddressRequest request = new SelectCartAddressRequest(ADDRESS_ID);

        //testTemp.putWithToken(URL, sampleToken, request, Object.class);
        HttpStatus statusCode = testTemp.putWithToken(URL, sampleToken, request, Object.class).getStatusCode();

        assert statusCode != null;
        assertEquals(HttpStatus.OK, statusCode);
        verify(cartService).setCartAddress(username, ADDRESS_ID);


    }

    @Test

    @DisplayName("การกำหนด การชำระ paymentMethod โดย call /cart/paymentMethod พร้อม user และ token การเพิ่มสินค้าสำเร็จ จะต้อง ได้ statusCode = OK และ verify อ็บเจอ็กต์ 2 ก้อนต้องเท่ากัน")
    void setPaymentMethod()  throws URISyntaxException {

        String sampleToken = "sampleToken";
        String username = "user1";

        String URL = "http://localhost:" + randomServerPort + "/cart/payment";

        int PAYMENT_METHOD = 1;


        when(userToken.decodeToken(sampleToken)).thenReturn(username);
        when(paymentService.isMyPaymentMethod(username, PAYMENT_METHOD)).thenReturn(true);

        CartPaymentMethodRequest request = new CartPaymentMethodRequest(PAYMENT_METHOD);
        HttpStatus statusCode = testTemp.putWithToken(URL, sampleToken, request, Object.class).getStatusCode();

        assert statusCode != null;
        assertEquals(HttpStatus.OK, statusCode);
        verify(cartService).setPaymentMethod(username, PAYMENT_METHOD);
    }
}