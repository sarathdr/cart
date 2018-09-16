package com.sky.cart.service;

import com.sky.cart.model.CartItem;
import com.sky.cart.model.Product;
import static org.junit.Assert.*;
import org.junit.Test;

public class ConsumePromotionTest {

    @Test
    public void testConsumePromotionWithProductType() {
        ConsumePromotion promotion = new ConsumePromotion();
        CartItem cartItem = new CartItem(
                new Product(1, "Headphones", Product.ProductType.AUDIO, 150.00),
                3);
        promotion.accept(cartItem);
        assertEquals(cartItem.getDiscount(), 135.00, 0);
    }

    @Test
    public void testConsumePromotionWithProduct() {
        ConsumePromotion promotion = new ConsumePromotion();
        CartItem cartItem = new CartItem(
                new Product(3, "AAA Batteries", Product.ProductType.POWER, 12),
                6);
        promotion.accept(cartItem);
        assertEquals(cartItem.getDiscount(), 24, 0);
    }
}
