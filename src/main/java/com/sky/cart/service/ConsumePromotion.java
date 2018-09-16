package com.sky.cart.service;

import com.sky.cart.dao.PromotionDao;
import com.sky.cart.model.CartItem;
import java.util.function.Consumer;

public class ConsumePromotion implements Consumer<CartItem> {

    private final PromotionDao promotionDao = new PromotionDao();

    @Override
    public void accept(final CartItem cartItem) {
        promotionDao.getPromotionsForProduct(cartItem.getItem()).stream().forEach(
                promotion -> {
                    final double totalPrice = cartItem.getNumberOfItems() * cartItem.getItem().getPrice();

                    double discount = 0;
                    if (promotion.getFreeItems() > 0
                            && promotion.getMinimumItems() > promotion.getFreeItems()
                            && cartItem.getNumberOfItems() >= promotion.getMinimumItems()) {
                        final int freeItems = (cartItem.getNumberOfItems() / promotion.getMinimumItems()) * promotion.getFreeItems();
                        discount = freeItems * cartItem.getItem().getPrice();
                    }

                    if (promotion.getOfferPercentage() != null) {
                        discount += totalPrice * promotion.getOfferPercentage();
                    }

                    cartItem.setDiscount(discount);
                }
        );
    }
}
