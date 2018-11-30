package com.cts.fasttack.sms.server.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		super.setRegisterErrorPageFilter(false);
		return application.sources(SmsServerApplication.class);
	}

}
