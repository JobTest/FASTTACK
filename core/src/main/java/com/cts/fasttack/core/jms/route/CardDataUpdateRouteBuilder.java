package com.cts.fasttack.core.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CardDataUpdateRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.CORE.cardDataUpdate")
                .routeId("cardDataUpdate")
                .process("cardDataUpdateProcessor");
    }
}
