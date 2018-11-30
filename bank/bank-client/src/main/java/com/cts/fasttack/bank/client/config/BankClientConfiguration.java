package com.cts.fasttack.bank.client.config;

import com.cts.fasttack.logging.ws.interceptor.LoggingClientHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Optional;

@Configuration
public class BankClientConfiguration {

    @Autowired
    private BankClientParameters parameters;

    @Autowired(required = false)
    @Qualifier("bankHttpsClientRequestFactory")
    private SimpleClientHttpRequestFactory httpsClientRequestFactory;

    @Bean("bankClientHostRestTemplate")
    public RestTemplate hostRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory factory = Optional.ofNullable(httpsClientRequestFactory).orElse(new SimpleClientHttpRequestFactory());
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
