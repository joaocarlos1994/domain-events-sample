package br.com.ddd.domainevents.domain.order;

import br.com.ddd.domainevents.domain.event.DomainEvent;
import br.com.ddd.domainevents.domain.event.DomainEventType;

public class OrderCreatedEvent extends DomainEvent {

    public OrderCreatedEvent(final Order source) {
        super(source);
    }

    @Override
    public Order getSource() {
        return (Order) super.getSource();
    }

    @Override
    public DomainEventType getType() {
        return DomainEventType.ORDER_CREATED;
    }
}
