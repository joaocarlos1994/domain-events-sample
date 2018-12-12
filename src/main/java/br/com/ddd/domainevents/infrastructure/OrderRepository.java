package br.com.ddd.domainevents.infrastructure;

import br.com.ddd.domainevents.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderRepository {

    private final List<Order> orders = new LinkedList<>();


    public void save(final Order newOrder) {
        if (!Objects.isNull(newOrder) && !orders.contains(newOrder)) {
            this.orders.add(newOrder);
        } else {
            throw new IllegalStateException("Order already exists");
        }
    }
}
