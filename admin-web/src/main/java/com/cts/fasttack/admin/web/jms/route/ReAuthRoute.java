package com.cts.fasttack.admin.web.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReAuthRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:topic:reAuth").routeId("reAuth")
                .process("reAuthProcessor");
    }
}
