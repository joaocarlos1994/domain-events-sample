package br.com.ddd.domainevents.domain.order;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@ToString(of = {"id", "userId", "status"})
@EqualsAndHashCode(of = { "id", "userId" })
public class Order {

    private final String id = UUID.randomUUID().toString();
    private final String userId;
    private final LinkedList<OrderItem> items = new LinkedList<>();
    private OrderStatus status = OrderStatus.IN_PROCESS;

    public Order (final String userId) {
        this.userId = userId;
    }

    public void addItems(final String productCode, final Integer quantidade) {
        if (!Objects.isNull(productCode) && !Objects.isNull(quantidade)) {
            this.items.add(new OrderItem(productCode, quantidade));
        }
    }

    public void cancelOrder() {
        this.status = OrderStatus.CANCELED;
    }

    public void finishOrder() {
        this.status = OrderStatus.COMPLETED;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean match(final String id) {
        return this.id.equals(id);
    }
}
