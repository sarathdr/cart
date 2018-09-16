package com.sky.cart.service;

import com.sky.cart.model.CartItem;
import com.sky.cart.model.Product;
import static org.junit.Assert.*;
import org.junit.Test;


public class CartServiceTest {


    @Test
    public void testAddItemToCartWithPercentagePromotion() {
        CartService cartService = new CartService();

        CartItem cartItem = cartService.addItemToCart(
                new Product(1, "Headphones", Product.ProductType.AUDIO, 150.00), 3);

        assertEquals( cartItem.getNumberOfItems(),3);
        assertEquals( cartItem.getDiscount(), 135.00, 0);
    }

    @Test
    public void testAddItemToCartWithFreeItemPromotion() {
        CartService cartService = new CartService();

        CartItem cartItem = cartService.addItemToCart(
                new Product(3, "AAA Batteries", Product.ProductType.POWER, 12),
                6);

        assertEquals( cartItem.getNumberOfItems(),6);
        assertEquals( cartItem.getDiscount(), 24, 0);

        cartItem = cartService.addItemToCart(
                new Product(3, "AAA Batteries", Product.ProductType.POWER, 12),
                7);

        assertEquals( cartItem.getDiscount(), 24, 0);

        cartItem = cartService.addItemToCart(
                new Product(3, "AAA Batteries", Product.ProductType.POWER, 12),
                8);

        assertEquals( cartItem.getDiscount(), 24, 0);
    }

    @Test
    public void testAddItemToCartDoNotApplyPromoIfTheMinimumIsNotBought() {
        CartService cartService = new CartService();

        CartItem cartItem = cartService.addItemToCart(
                new Product(3, "AAA Batteries", Product.ProductType.POWER, 12),
                2);

        assertEquals( cartItem.getNumberOfItems(),2);
        assertEquals( cartItem.getDiscount(), 0, 0);
    }

    @Test
    public void testAddItemToCartWithNoPromotion() {
        CartService cartService = new CartService();

        CartItem cartItem = cartService.addItemToCart(
                new Product(3, "AAA Batteries", Product.ProductType.POWER, 12),
                2);

        assertEquals( cartItem.getDiscount(), 0, 0);

        cartItem = cartService.addItemToCart(
                new Product(4, "Protein Bars (Box) ", Product.ProductType.FOOD, 25.00),
                10);

        assertEquals( cartItem.getDiscount(), 0, 0);
    }


}