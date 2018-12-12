package br.com.ddd.domainevents.domain.stock;

import br.com.ddd.domainevents.application.StockApplicationService;
import br.com.ddd.domainevents.domain.event.DomainEvent;
import br.com.ddd.domainevents.domain.event.DomainEventListener;
import br.com.ddd.domainevents.domain.order.Order;
import br.com.ddd.domainevents.domain.order.OrderCreatedEvent;
import br.com.ddd.domainevents.domain.order.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StockListener implements DomainEventListener {

    private final StockApplicationService service;

    @Override
    public void notify(final DomainEvent event) throws Exception {
        final OrderCreatedEvent orderCreated = (OrderCreatedEvent) event;
        final Order source = orderCreated.getSource();
        source.getItems().forEach(item -> service.bookProduct(item.getProductCode(), item.getQuantidade()));
    }
}
