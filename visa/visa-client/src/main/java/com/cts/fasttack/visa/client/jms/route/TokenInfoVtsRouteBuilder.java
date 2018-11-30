package com.cts.fasttack.visa.client.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.cts.fasttack.visa.client.jms.processor.TokenInfoVtsProcessor;

/**
 * Route builder for {@link TokenInfoVtsProcessor}.
 *
 * @author v.semerkov
 */
@Component
public class TokenInfoVtsRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.VTS.tokenInfo")
                .routeId("tokenInfo")
                .process("tokenInfoVtsProcessor");
    }
}
