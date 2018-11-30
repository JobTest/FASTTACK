package com.cts.fasttack.mdes.client.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenSearchMdesRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.MDES.tokenSearch").routeId("tokenSearch")
                .process("tokenSearchMdesProcessor");
    }
}
