package br.com.ddd.domainevents.application;

import br.com.ddd.domainevents.domain.event.DomainEventsNotifier;
import br.com.ddd.domainevents.domain.order.Order;
import br.com.ddd.domainevents.domain.order.OrderCreatedEvent;
import br.com.ddd.domainevents.infrastructure.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderApplicationService {

    private final OrderRepository repository;
    private final DomainEventsNotifier notifier;

    public void createOrder(final String userId, final String productRegisterNumber, final Integer quantidade) throws Exception {
        final Order newOrder = new Order(userId);
        newOrder.addItems(productRegisterNumber, quantidade);
        repository.save(newOrder);
        notifier.notifyListeners(new OrderCreatedEvent(newOrder));
    }
}
