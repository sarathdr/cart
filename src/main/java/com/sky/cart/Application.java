package com.sky.cart;

import com.sky.cart.data.DataLoader;
import com.sky.cart.model.CartItem;
import com.sky.cart.model.Product;
import com.sky.cart.service.CartService;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("=================  Show cart ========================================");

        final List<Product> products = DataLoader.getProducts();

        final CartService cartService = new CartService();
        final List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartService.addItemToCart(products.get(1), 1));
        cartItems.add(cartService.addItemToCart(products.get(2), 5));
        cartItems.add(cartService.addItemToCart(products.get(3), 2));


        System.out.format("%-25s%-15s%-15s%-15s%-15s\n",
                new Object[]{"Item name", "Quantity", "Total Price", "Discount", "Net Price"});

        cartItems.stream().forEach(
                cartItem -> {
                    final double totalPrice = cartItem.getItem().getPrice() * cartItem.getNumberOfItems();
                    System.out.format("%-25s%-15s%-15s%-15s%-15s\n",
                            new Object[]{
                                    cartItem.getItem().getName(),
                                    cartItem.getNumberOfItems(),
                                    totalPrice,
                                    cartItem.getDiscount(),
                                    (totalPrice - cartItem.getDiscount())
                            });
                }
        );
    }
}
