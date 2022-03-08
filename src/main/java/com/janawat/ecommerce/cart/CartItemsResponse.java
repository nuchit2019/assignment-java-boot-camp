package com.janawat.ecommerce.cart;

import com.janawat.ecommerce.product.ProductService;
import com.janawat.ecommerce.model.Cart;
import com.janawat.ecommerce.model.CartItem;
import com.janawat.ecommerce.model.Product;

import java.util.ArrayList;

public class CartItemsResponse {
    private ArrayList<CartItemResponse> items;

    public CartItemsResponse() {
        this.items = new ArrayList<>();
    }

    public static CartItemsResponse fromCart(
            ProductService productService, Cart cart) {
        CartItemsResponse response = new CartItemsResponse();
        for (CartItem item : cart.getItems()) {
            Product product = productService.getProduct(item.getProductId());

            response.add(CartItemResponse.ofProduct(product, item.getQuantity()));
        }

        return response;
    }

    private void add(CartItemResponse cartItemResponse) {
        items.add(cartItemResponse);
    }

    private CartItemResponse get(int index) {
        return items.get(index);
    }

    public ArrayList<CartItemResponse> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItemResponse> items) {
        this.items = items;
    }

    public int size() {
        return this.items.size();
    }

}
