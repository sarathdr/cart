package com.sky.cart.model;

public class CartItem {

    private Product item;
    private int numberOfItems;
    private double discount;

    public CartItem(Product item, int numberOfItems) {
        this.item = item;
        this.numberOfItems = numberOfItems;
    }

    public Product getItem() {
        return item;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
