package com.cts.fasttack.visa.client.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenLifecycleVtsRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.VTS.tokenLifecycle").routeId("tokenLifecycle")
                .process("tokenLifecycleVtsProcessor");
    }
}
