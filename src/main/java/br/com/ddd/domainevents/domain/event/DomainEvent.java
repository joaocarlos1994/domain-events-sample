package br.com.ddd.domainevents.domain.event;

import java.util.EventObject;

/**
 * A {@code DomainEvent} representa um evento abstrato que vai ocorrer dentro do
 * dominio.
 *
 * @author Joao Batista
 * @version 1.0 11/12/2018
 */
public abstract class DomainEvent  extends EventObject {

    /**
     * Retorna o tipo do evento de dominio
     */
    public abstract DomainEventType getType();

    public DomainEvent(final Object source) {
        super(source);
    }
}
