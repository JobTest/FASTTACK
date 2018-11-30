package com.cts.fasttack.admin.web.config;

import com.cts.fasttack.admin.web.config.context.parameter.AdminWebRestCoreParameters;
import com.cts.fasttack.common.core.rest.jwt.interceptor.JwtClientHttpInterceptor;
import com.cts.fasttack.common.core.rest.jwt.service.JwtService;
import com.cts.fasttack.logging.ws.interceptor.LoggingClientHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class RestConfig {

    @Autowired
    private AdminWebRestCoreParameters adminWebRestCoreParameters;

    @Autowired
    private JwtService jwtService;


    @Bean("adminWebRestTemplate")
    public RestTemplate adminWebRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(clientHttpRequestFactory());
        restTemplate.setInterceptors(clientHttpRequestInterceptors());
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(adminWebRestCoreParameters.getConnectionTimeoutInMills());
        factory.setReadTimeout(adminWebRestCoreParameters.getReadTimeoutInMills());
        return new BufferingClientHttpRequestFactory(factory);
    }

    @Bean
    public List<ClientHttpRequestInterceptor> clientHttpRequestInterceptors() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>(2);
        interceptors.add(new JwtClientHttpInterceptor(jwtService, AdminWebApplication.ORIGINATOR, TimeUnit.MILLISECONDS.toSeconds(adminWebRestCoreParameters.getConnectionTimeoutInMills())));
        interceptors.add(new LoggingClientHttpRequestInterceptor("com.cts.fasttack"));
        return interceptors;
    }
}
