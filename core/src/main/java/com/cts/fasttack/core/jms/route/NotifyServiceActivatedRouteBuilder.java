package com.cts.fasttack.core.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * JMS route builder for notifyServiceActivated queue
 *
 * @author a.lipavets
 */
@Component
public class NotifyServiceActivatedRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.MDES.notifyServiceActivated").routeId("notifyServiceActivated")
                .process("notifyServiceActivatedProcessor");
    }
}
