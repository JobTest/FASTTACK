package com.cts.fasttack.visa.client.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class TokenInruiryVtsRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.VTS.tokenInquiry").routeId("tokenInquiry")
                .process("tokenInquiryVtsProcessor");
    }
}
