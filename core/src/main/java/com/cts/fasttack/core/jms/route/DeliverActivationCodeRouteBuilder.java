package com.cts.fasttack.core.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * JMS route builder for deliverActivationCode queue
 *
 * @author a.lipavets
 */
@Component
public class DeliverActivationCodeRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
         from("jms:queue:FASTTACK.MDES.deliverActivationCode?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                 .routeId("deliverActivationCode")
                 .process("deliverActivationCodeProcessor");
    }
}
