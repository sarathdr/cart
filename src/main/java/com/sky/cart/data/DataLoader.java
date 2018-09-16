package com.sky.cart.data;

import com.sky.cart.model.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataLoader {

    public static List<Product> getProducts() {
        final List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Headphones", Product.ProductType.AUDIO, 150.00));
        products.add(new Product(2, "Speakers", Product.ProductType.AUDIO, 85.00));
        products.add(new Product(3, "AAA Batteries", Product.ProductType.POWER, 0.85));
        products.add(new Product(4, "Protein Bars (Box) ", Product.ProductType.FOOD, 25.00));

        return Collections.unmodifiableList(products);
    }
}
