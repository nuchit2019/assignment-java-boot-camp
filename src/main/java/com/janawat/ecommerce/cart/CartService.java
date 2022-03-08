package com.janawat.ecommerce.cart;

import com.janawat.ecommerce.product.ProductService;
import com.janawat.ecommerce.model.Cart;
import com.janawat.ecommerce.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public CartRepository getCartRepository() {
        return cartRepository;
    }

    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addItemToCart(String username, CartItem item) {
        Cart cart = getCart(username);
        cart.addItem(item);


        Boolean isInstokCanOrder = productService.isInstokCanOrder(item.getProductId(),item.getQuantity());

        if (isInstokCanOrder) {

            productService.adjustProduct(item.getProductId(),item.getQuantity());

            cartRepository.save(cart);
        }

    }

    public Cart getCart(String username) {
        return cartRepository.findById(username)
                .orElseGet(() -> new Cart(username));
    }

    public void clearCart(String username) {
        if (cartRepository.existsById(username)) {
            cartRepository.deleteById(username);
        }
    }

    @Transactional
    public void setCartAddress(String username, int addressId) {
        Cart cart = getCart(username);
        cart.setAddressId(addressId);


        cartRepository.save(cart);

    }

    @Transactional
    public void setPaymentMethod(String username, int paymentMethod) {
        Cart cart = getCart(username);
        cart.setPaymentId(paymentMethod);


        cartRepository.save(cart);
    }


    public void addItemToMyCart(String username, CartItem item) {
        Cart cart = getCart(username);

        cart.addItem(item);

        cartRepository.save(cart);
    }

    public void addItemCart(String username, CartItem item) {
        Cart cart = getCart(username);
        cart.addItem(item);

        cartRepository.save(cart);

        if (item.getQuantity() > 0) {
            Boolean isInstokCanOrder = productService.isInstokCanOrder(item.getProductId(),item.getQuantity());
            if (isInstokCanOrder) {
                productService.adjustProduct(item.getProductId(),item.getQuantity());
                cartRepository.save(cart);
            }

        } else {
            System.out.println("CartItem Quantity...=0");
        }
    }
}
