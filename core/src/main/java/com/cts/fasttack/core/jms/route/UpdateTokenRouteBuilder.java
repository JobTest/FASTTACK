package com.cts.fasttack.core.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class UpdateTokenRouteBuilder extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.CORE.updateToken?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("updateToken")
                .process("updateTokenProcessor");
    }
}
