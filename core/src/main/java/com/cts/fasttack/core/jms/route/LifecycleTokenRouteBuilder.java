package com.cts.fasttack.core.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class LifecycleTokenRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.BANK.lifecycleToken")
                .routeId("lifecycleToken")
                .process("lifecycleTokenProcessor");
    }
}
