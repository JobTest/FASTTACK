package com.cts.fasttack.core.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class NotifyTokenUpdatedRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.MDES.notifyTokenUpdated")
                .routeId("notifyTokenUpdated")
                .process("notifyTokenUpdatedProcessor");
    }
}
