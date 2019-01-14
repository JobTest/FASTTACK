package com.cts.fasttack.mdes.client.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenUpdateMdesRouteBuilder extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.MDES.tokenUpdate?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS).routeId("tokenUpdate")
                .process("tokenUpdateMdesProcessor");
    }
}
