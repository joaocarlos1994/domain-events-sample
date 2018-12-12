/*
 * @(#)DomainEventsNotifier.java 1.0 26/02/2016
 *
 * Copyright (c) 2016, Embraer. All rights reserved. Embraer S/A
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.ddd.domainevents.domain.event;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A classe <code>DomainEventsNotifier</code> contem os tipo de eventos de
 * dominio e seus respectivos <i>ouvintes</i>, e e responsavel por notifica-los
 * quando um evento de dominio acontece.
 *
 * @author Roberto Perillo
 * @version 1.0 26/02/2016
 */
@Component
public class DomainEventsNotifier {

    /**
     * O mapa que contem os tipos de eventos de dominio e seus respectivos
     * ouvintes
     */
    private final Map<DomainEventType, List<DomainEventListener>> listeners;

    public DomainEventsNotifier(final Map<DomainEventType, List<DomainEventListener>> listeners) {
        super();
        this.listeners = new HashMap<>(listeners.size());
        this.listeners.putAll(listeners);
    }

    /**
     * Notifica os ouvintes de um tipo de evento de dominio.
     *
     * @param event
     *            O evento a ser tratado pelos ouvintes.
     * @throws Exception
     *             Caso ocorra alguma excecao no tratamento do evento.
     */
    public void notifyListeners(final DomainEvent event) throws Exception {
        final List<DomainEventListener> domainEventListeners = listeners.get(event.getType());
        if (domainEventListeners != null) {
            for (final DomainEventListener listener : domainEventListeners) {
                listener.notify(event);
            }
        }
    }
}