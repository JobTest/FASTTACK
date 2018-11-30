package com.cts.fasttack.ih_sv.client.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author d.ishchenko
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		super.setRegisterErrorPageFilter(false);
		return application.sources(IssuerHostSvClientApplication.class);
	}

}
