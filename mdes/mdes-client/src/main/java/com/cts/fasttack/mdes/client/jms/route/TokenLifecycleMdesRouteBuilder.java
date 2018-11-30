package com.cts.fasttack.mdes.client.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenLifecycleMdesRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.MDES.tokenLifecycle").routeId("tokenLifecycle")
                .process("tokenLifecycleMdesProcessor");
    }
}
