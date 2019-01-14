package com.cts.fasttack.core.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenLifecycleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.CORE.tokenLifecycle?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS).routeId("tokenLifecycle")
                .process("tokenLifecycleProcessor");
    }
}
