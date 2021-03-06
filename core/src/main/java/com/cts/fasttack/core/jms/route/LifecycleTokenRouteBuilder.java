package com.cts.fasttack.core.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class LifecycleTokenRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.BANK.lifecycleToken?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("lifecycleToken")
                .process("lifecycleTokenProcessor");
    }
}
