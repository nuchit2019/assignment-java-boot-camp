package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Cart;
import com.janawatECommerceSystem.janawatECommerceSystem.models.CartItem;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionScoped;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;


    public void addItemToCart(String username, CartItem item) {
        Cart cart = getCart(username);
        cart.addItem(item);

        System.out.println("============== :addItemToCart: ==============");
        System.out.println("product id:"+item.getProductId());
        System.out.println("product id:"+item.getQuantity());

        Boolean isInstokCanOrder = productService.isInstokCanOrder(item);

        if(isInstokCanOrder) {
            System.out.println("...1:productService.adjustProduct(item)");
            productService.adjustProduct(item);
            System.out.println("...2:cartRepository.save(cart)");
            cartRepository.save(cart);
            System.out.println("...3:cartRepository.save(cart)");
        }

        System.out.println("isInstokCanOrder:"+isInstokCanOrder);
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

        System.out.println("setCartAddress:========= ");
        System.out.println("cart.getUsername(): " + cart.getUsername());
        System.out.println("cart.getAddressId(): " + cart.getAddressId());

        cartRepository.save(cart);

    }

    @Transactional
    public void setPaymentMethod(String username, int paymentMethod) {
        Cart cart = getCart(username);
        cart.setPaymentId(paymentMethod);

        System.out.println(" ========= :setPaymentMethod: ========= ");
        System.out.println("cart.getUsername(): " + cart.getUsername());
        System.out.println("cart.getPaymentId(): " + cart.getPaymentId());

        cartRepository.save(cart);
    }

    public void addItemCart(String username, CartItem item) {
        Cart cart = getCart(username);
        cart.addItem(item);

//        cartRepository.save(cart);

        System.out.println("============== :addItemToCart: ==============");
        System.out.println("1 CartItem.getProductId():"+item.getProductId());
        System.out.println("2 CartItem.getQuantity():"+item.getQuantity());

        System.out.println("...cart.getUsername():"+cart.getUsername());


        if(item.getQuantity()>0 ) {
            Boolean isInstokCanOrder = productService.isInstokCanOrder(item);
            System.out.println("3 isInstokCanOrder:" + isInstokCanOrder);

            if (isInstokCanOrder) {
                System.out.println("...3.1:productService.adjustProduct(item)");
                productService.adjustProduct(item);
                System.out.println("...3.2:cartRepository.save(cart)");

                cartRepository.save(cart);

                System.out.println("...3.3:cartRepository.save(cart)");
            }

            System.out.println("4 addItemCart complete...");
        }
        else {
            System.out.println("CartItem Quantity...=0");
        }
    }
}
