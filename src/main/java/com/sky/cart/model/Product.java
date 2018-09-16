package com.sky.cart.model;

public class Product {

    public enum ProductType {
        AUDIO,
        POWER,
        FOOD
    }

    private int id;
    private String name;
    private ProductType type;
    private double price;

    public Product(int id, String name, ProductType type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
