package com.cts.fasttack.mdes.client.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.cts.fasttack.mdes.client.jms.processor.TokenInfoMdesProcessor;

/**
 * Route builder for {@link TokenInfoMdesProcessor}.
 *
 * @author v.semerkov
 */
@Component
public class TokenInfoMdesRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.MDES.tokenInfo?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("tokenInfo")
                .process("tokenInfoMdesProcessor");
    }
}
