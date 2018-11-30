package com.cts.fasttack.core.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TokenDeactivateNotificationRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.CORE.tokenDeactivateNotification")
                .routeId("tokenDeactivateNotification")
                .process("tokenDeactivateNotificationProcessor");
    }
}
