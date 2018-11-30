package com.cts.fasttack.ih_sv.client.config;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.logging.ws.interceptor.LoggingClientHttpRequestInterceptor;

/**
 * @author d.ishchenko
 */
@Configuration
public class IssuerHostSvClientConfiguration {

	@Autowired
	private IssuerHostSvClientParameters parameters;

	@Autowired(required = false)
	@Qualifier("issuerHostSvHttpsClientRequestFactory")
	private SimpleClientHttpRequestFactory httpsClientRequestFactory;

	@Bean("issuerHostSvRestTemplate")
	public RestTemplate issuerHostSvRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory factory = Optional.ofNullable(httpsClientRequestFactory)
				.orElse(new SimpleClientHttpRequestFactory());
		factory.setConnectTimeout(parameters.getConnectionTimeoutInMills());
		factory.setReadTimeout(parameters.getReadTimeoutInMills());
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(factory));
		restTemplate.setInterceptors(Collections.singletonList(loggingClientHttpRequestInterceptor()));
		restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
		return restTemplate;
	}

	@Bean
	public ClientHttpRequestInterceptor loggingClientHttpRequestInterceptor() {
		return new LoggingClientHttpRequestInterceptor("com.cts.fasttack");
	}

}
