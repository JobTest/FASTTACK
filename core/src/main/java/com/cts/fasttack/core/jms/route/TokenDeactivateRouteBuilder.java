package com.cts.fasttack.core.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TokenDeactivateRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.CORE.tokenDeactivate?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("tokenDeactivate")
                .process("tokenDeactivateProcessor");
    }
}
