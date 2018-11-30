package com.cts.fasttack.mdes.client.config;

import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.logging.ws.interceptor.LoggingClientHttpRequestInterceptor;
import com.cts.fasttack.mdes.client.interceptor.MdesAuthInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Leliuk
 */
@Configuration
public class MdesRestConfiguration {

    @Autowired @Qualifier("clientRestProxy")
    private Proxy clientProxy;

    @Autowired
    private MdesRestParameters parameters;

    @Bean
    public RestTemplate mdesRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(mdesSimpleHttpsClientRequestFactory());
        restTemplate.setMessageConverters(mdesMessageConverters());
        restTemplate.setInterceptors(mdesClientHttpRequestInterceptors());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory mdesSimpleHttpsClientRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(parameters.getConnectionTimeoutInMills());
        factory.setReadTimeout(parameters.getReadTimeoutInMills());
        factory.setProxy(clientProxy);
        return new BufferingClientHttpRequestFactory(factory);
    }

    @Bean
    public List<HttpMessageConverter<?>> mdesMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>(2);
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(mdesObjectMapper());
        converters.add(jsonConverter);
        converters.add(new Jaxb2RootElementHttpMessageConverter());
        return converters;
    }

    @Bean
    public ObjectMapper mdesObjectMapper() {
        ObjectMapper objectMapper = JsonUtil.getObjectMapper().copy();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return objectMapper;
    }

    @Bean
    public List<ClientHttpRequestInterceptor> mdesClientHttpRequestInterceptors() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>(2);
        interceptors.add(mdesAuthInterceptor());
        interceptors.add(new LoggingClientHttpRequestInterceptor("com.cts.fasttack"));
        return interceptors;
    }

    @Bean
    public MdesAuthInterceptor mdesAuthInterceptor(){
        return new MdesAuthInterceptor();
    }
}
