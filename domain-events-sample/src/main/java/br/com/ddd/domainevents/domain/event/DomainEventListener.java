package br.com.ddd.domainevents.domain.event;


/**
 * A {@code DomainEventListener} representa o contrato que todos o listener que desejam receber
 * eventos precisam implementar.
 *
 * @author Joao Batista
 * @version 1.0 11/12/2018
 */
@FunctionalInterface
public interface DomainEventListener {

    void notify(final DomainEvent event) throws Exception;

}
