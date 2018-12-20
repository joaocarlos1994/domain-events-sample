package br.com.ddd.domainevents.domain.stock;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = {"code"})
public class Product {

    private final String code;
    private final String name;
    private final BigDecimal price;

    public boolean match(final String productCode) {
        return  code.equals(productCode);
    }
}
