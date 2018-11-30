package com.cts.fasttack.ih.client.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.ih.client.converter.xml.XmlDigitalSignatureMarshallingHttpMessageConverter;
import com.cts.fasttack.logging.ws.interceptor.LoggingClientHttpRequestInterceptor;

/**
 * @author Anton Leliuk
 */
@Configuration
public class IssuerHostClientConfiguration {

    @Autowired
    private IssuerHostClientParameters parameters;

    @Bean("issuerHostRestTemplate")
    public RestTemplate issuerHostRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(issuerHostClientHttpRequestFactory());
        restTemplate.setInterceptors(Collections.singletonList(issuerHostClientHttpRequestInterceptor()));
        restTemplate.setMessageConverters(Collections.singletonList(issuerHostMessageConverter()));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory issuerHostClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(parameters.getConnectionTimeoutInMills());
        factory.setReadTimeout(parameters.getReadTimeoutInMills());
        return new BufferingClientHttpRequestFactory(factory);
    }

    @Bean
    public ClientHttpRequestInterceptor issuerHostClientHttpRequestInterceptor() {
        return new LoggingClientHttpRequestInterceptor("com.cts.fasttack");
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.cts.fasttack.ih.client.dto");
        return marshaller;
    }

    @Bean
    public MarshallingHttpMessageConverter issuerHostMessageConverter(){
        return new XmlDigitalSignatureMarshallingHttpMessageConverter(jaxb2Marshaller(), parameters);
    }

}
