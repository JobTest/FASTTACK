package com.cts.fasttack.ih_sv.client.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author d.ishchenko
 */
@Component
public class CardStatusVerificationRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:queue:FASTTACK.MDES.cardStatusVerification").routeId("cardStatusVerificationRoute")
				.process("cardStatusVerificationProcessor");
	}

}
