package com.cts.fasttack.ih.client.jms;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * JMS route builder for card status verification.
 *
 * @author v.semerkov
 */
@Component
public class CardStatusVerificationRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.MDES.cardStatusVerification?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("cardStatusVerificationRoute")
                .process("cardStatusVerificationProcessor");
    }
}