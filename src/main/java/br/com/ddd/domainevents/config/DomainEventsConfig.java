/*
 * @(#)DomainEventsConfig.java 1.0 15/11/2016
 *
 * Copyright (c) 2016, Embraer. All rights reserved. Embraer S/A
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.ddd.domainevents.config;

import br.com.ddd.domainevents.domain.event.DomainEvent;
import br.com.ddd.domainevents.domain.event.DomainEventListener;
import br.com.ddd.domainevents.domain.event.DomainEventType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por registrar os listeners de cada domain event.
 *
 * @author Joao Batista
 * @version 1.0 11/12/2018
 */
@Configuration
public class DomainEventsConfig {

    /**
     * Configuracao dos listeners da aplicacao
     *
     * @param
     * @return o mapa contendo os listeners
     */
    @Bean
    public Map<DomainEventType, List<DomainEventListener>> listeners(final DomainEventListener stockListener) {
        final Map<DomainEventType, List<DomainEventListener>> map = new EnumMap<>(DomainEventType.class);
        map.put(DomainEventType.ORDER_CREATED, Arrays.asList(stockListener));
        return map;
    }
}