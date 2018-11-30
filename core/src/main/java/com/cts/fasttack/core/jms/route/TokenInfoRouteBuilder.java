package com.cts.fasttack.core.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.cts.fasttack.core.jms.processor.TokenInfoProcessor;

/**
 * Route builder for {@link TokenInfoProcessor}.
 *
 * @author v.semerkov
 */
@Component
public class TokenInfoRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.BANK.tokenInfo")
                .routeId("tokenInfo")
                .process("tokenInfoProcessor");
    }
}
