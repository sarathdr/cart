package com.sky.cart.model;

public class Promotion {

    private String name;
    private Double offerPercentage;
    private int freeItems;
    private int minimumItems;

    public Promotion(final String name, final Double offerPercentage) {
        this.name = name;
        this.offerPercentage = offerPercentage;
    }

    public Promotion(final String name, final int freeItems, final int minimumItems) {
        this.name = name;
        this.freeItems = freeItems;
        this.minimumItems = minimumItems;
    }

    public String getName() {
        return name;
    }

    public Double getOfferPercentage() {
        return offerPercentage;
    }

    public int getFreeItems() {
        return freeItems;
    }

    public int getMinimumItems() {
        return minimumItems;
    }

}
