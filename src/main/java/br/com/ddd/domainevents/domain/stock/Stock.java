package br.com.ddd.domainevents.domain.stock;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "location"})
public class Stock {

    private final String location;
    private final String id = UUID.randomUUID().toString();
    private final List<Product> products = new LinkedList<>();
    private final List<Product> bookProducts = new LinkedList<>();

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

    public boolean matchProductCode(final String productCode) {
        return products.stream().anyMatch(product -> product.match(productCode));
    }

    public void bookProduct(final String productCode, final Integer quantity) {
        final List<Product> productsToBook = products.stream()
                .filter(product -> product.match(productCode))
                .collect(Collectors.toList());

        if (productsToBook.size() == quantity) {
            bookProducts.addAll(productsToBook);
            productsToBook.forEach(this::removeProduct);
        } else {
            throw new RuntimeException("Quantity unavailable");
        }
    }

    public boolean match(final String id) {
        return this.id.equals(id);
    }
}
