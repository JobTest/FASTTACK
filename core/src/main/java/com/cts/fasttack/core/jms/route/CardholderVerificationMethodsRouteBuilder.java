package com.cts.fasttack.core.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class CardholderVerificationMethodsRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.VTS.cardholderVerificationMethods")
                .routeId("cardholderVerificationMethods")
                .process("cardholderVerificationMethodsProcessor");
    }
}
