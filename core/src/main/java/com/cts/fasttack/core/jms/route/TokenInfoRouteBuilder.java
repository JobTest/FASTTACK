package com.cts.fasttack.core.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
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
        from("jms:queue:FASTTACK.BANK.tokenInfo?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("tokenInfo")
                .process("tokenInfoProcessor");
    }
}
