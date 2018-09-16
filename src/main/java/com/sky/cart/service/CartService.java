package com.sky.cart.service;

import com.sky.cart.model.CartItem;
import com.sky.cart.model.Product;

public class CartService {

    private ConsumePromotion promotion = new ConsumePromotion();

    public CartItem addItemToCart(final Product product, final int numberOfItems) {
        final CartItem newItem = new CartItem(product, numberOfItems);
        promotion.accept(newItem);
        return newItem;
    }
}
