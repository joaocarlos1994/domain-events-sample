package br.com.ddd.domainevents.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItem {

    private final String productCode;
    private final Integer quantidade;

}
