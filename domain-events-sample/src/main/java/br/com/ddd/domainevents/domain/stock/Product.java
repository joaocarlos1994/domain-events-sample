package br.com.ddd.domainevents.domain.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Product {

    private final String code;
    private final String name;
    private final BigDecimal price;

}
