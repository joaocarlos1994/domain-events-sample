package br.com.ddd.domainevents.domain.stock;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Stock {

    private final List<Product> products = new LinkedList<>();

    public void addProduct(final Product newProduct) {
        if (!Objects.isNull(newProduct)) {
            this.products.add(newProduct);
        }
    }


    public void removeProduct(final Product newProduct) {
        if (!Objects.isNull(newProduct) && products.contains(newProduct)) {
            this.products.add(newProduct);
        }
        throw new IllegalStateException("Product unavailable");
    }
}
