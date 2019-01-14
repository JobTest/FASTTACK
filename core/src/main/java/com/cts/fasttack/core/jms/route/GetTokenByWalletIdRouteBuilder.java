package com.cts.fasttack.core.jms.route;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.cts.fasttack.core.jms.processor.GetTokenByWalletIdProcessor;

/**
 * Route builder for {@link GetTokenByWalletIdProcessor}.
 *
 * @author v.semerkov
 */
@Component
public class GetTokenByWalletIdRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FASTTACK.BANK.listTokensByWalletId?concurrentConsumers=" + PropertyActiveMQConnectionFactory.CONCURRENT_CONSUMERS)
                .routeId("listTokensByWalletId")
                .process("getTokenByWalletIdProcessor");
    }
}
