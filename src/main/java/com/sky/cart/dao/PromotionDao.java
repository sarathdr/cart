package com.sky.cart.dao;

import com.sky.cart.data.DataLoader;
import com.sky.cart.model.Product;
import com.sky.cart.model.Promotion;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PromotionDao {

    private final static Map<Integer, Promotion> PROMO_BY_ITEM = new HashMap<>();

    static {
        PROMO_BY_ITEM.put(
                DataLoader.getProducts().get(2).getId(),
                new Promotion("3 for the price of 2", 1, 3)
        );
    }

    private final static Map<Product.ProductType, Promotion> PROMO_BY_ITEM_TYPE = new EnumMap<>(Product.ProductType.class);

    static {
        PROMO_BY_ITEM_TYPE.put(
                Product.ProductType.AUDIO,
                new Promotion("30% discount on price", 0.3)
        );
    }

    public List<Promotion> getPromotionsForProduct(final Product product) {
        final List<Promotion> promotions = new ArrayList<>();
        promotions.add(PROMO_BY_ITEM_TYPE.get(product.getType()));
        promotions.add(PROMO_BY_ITEM.get(product.getId()));
        return promotions.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}
