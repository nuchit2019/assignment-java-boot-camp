package com.janawat.ecommerce.services;

import com.janawat.ecommerce.cart.CartService;
import com.janawat.ecommerce.model.Cart;
import com.janawat.ecommerce.model.CartItem;
import com.janawat.ecommerce.cart.CartRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private CartRepository cartRepository;


    @Test
    @DisplayName("Update addreessId=2 ค้นหา cart ตาม user=user1 จะต้องได้  addreessId = 2")
    void setCartAddress() {
        Integer expected = 2;

        String username = "user1";
        int addressId = 1;

        CartItem cartItem = new CartItem();
        cartItem.setProductId(1);

        cartItem.setQuantity(2);

        ArrayList<CartItem> lscartItem = new ArrayList<>();
        lscartItem.add(cartItem);

        Cart cart = new Cart();
        cart.setUsername(username);
        cart.setAddressId(addressId); //<======================================== default address
        cart.setItems(lscartItem);

        when(cartRepository.findById(username)).thenReturn(Optional.of(cart));

        CartService cartService = new CartService();
        cartService.setCartRepository(cartRepository);

        cartService.setCartAddress(username, 2);//<====================  update address
        Integer result = cartService.getCart(username).getAddressId();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Update PaymentMethod=2 ค้นหา cart ตาม user=user1 จะต้องได้  PaymentMethodId = 2")
    void setPaymentMethod() {
        Integer expected = 2;

        String username = "user1";
        int paymentMethodId = 1;

        CartItem cartItem = new CartItem();
        cartItem.setProductId(1);
        cartItem.setQuantity(2);

        ArrayList<CartItem> lscartItem = new ArrayList<>();
        lscartItem.add(cartItem);

        Cart cart = new Cart();
        cart.setUsername(username);
        cart.setPaymentId(paymentMethodId); //<======================================== default paymentMethodId
        cart.setItems(lscartItem);

        when(cartRepository.findById(username)).thenReturn(Optional.of(cart));

        CartService cartService = new CartService();
        cartService.setCartRepository(cartRepository);

        cartService.setCartAddress(username, 2);//<====================  update paymentMethodId
        Integer result = cartService.getCart(username).getAddressId();

        assertEquals(expected, result);

    }


    @Test
    @DisplayName("เพิ่ม CartItem โดยกำหนด username = user1,ProductId = 1 ค้นหหา โดยส่ง user=user1 จะต้องได้ ProductId = 1")
    public void addItemCart() {

        Integer expected = 1;

        String username = "user1";
        int paymentMethodId = 1;

        CartItem cartItem = new CartItem();
        cartItem.setProductId(1);
        cartItem.setQuantity(2);

        ArrayList<CartItem> lscartItem = new ArrayList<>();
        lscartItem.add(cartItem);

        Cart cart = new Cart();
        cart.setUsername(username);
        cart.setPaymentId(paymentMethodId);
        cart.setItems(lscartItem);

        when(cartRepository.findById(username)).thenReturn(Optional.of(cart));

        CartService cartService = new CartService();
        cartService.setCartRepository(cartRepository);

        Integer result = cartService.getCart(username).getPaymentId();

        assertEquals(expected, result);
    }

}