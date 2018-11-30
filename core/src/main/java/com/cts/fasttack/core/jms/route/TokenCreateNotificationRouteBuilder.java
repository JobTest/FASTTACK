package com.cts.fasttack.core.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCreateNotificationRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:FASTTACK.VTS.tokenCreateNotification").routeId("tokenCreateNotification")
                .process("tokenCreateNotificationProcessor");
    }
}
