package com.cts.fasttack.visa.client.config;

import com.cts.fasttack.logging.ws.interceptor.LoggingClientHttpRequestInterceptor;
import com.cts.fasttack.visa.client.factory.VisaClientHttpsRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anton Leliuk
 */
@Configuration
public class VisaRestConfiguration {

    @Autowired
    private VisaConnectionParameters connectionParameters;

    @Autowired
    @Qualifier("clientRestProxy")
    private Proxy clientProxy;

    @Bean
    public RestTemplate visaClientRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(visaSimpleHttpsClientRequestFactory()));
        restTemplate.setMessageConverters(Collections.singletonList(visaXmlMessageConverter()));
        restTemplate.setInterceptors(visaClientHttpRequestInterceptors());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory visaSimpleHttpsClientRequestFactory() {
        VisaClientHttpsRequestFactory factory = new VisaClientHttpsRequestFactory();
        factory.setConnectTimeout(connectionParameters.getConnectionTimeoutInMills());
        factory.setReadTimeout(connectionParameters.getReadTimeoutInMills());
        factory.setProxy(clientProxy);
        return factory;
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.cts.fasttack.visa.client.dto");
        return marshaller;
    }

    @Bean
    public MarshallingHttpMessageConverter visaXmlMessageConverter(){
        return new MarshallingHttpMessageConverter(jaxb2Marshaller());
    }

    @Bean
    public List<ClientHttpRequestInterceptor> visaClientHttpRequestInterceptors() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>(2);
        interceptors.add(new BasicAuthorizationInterceptor(connectionParameters.getBasicAuthUsername(), connectionParameters.getBasicAuthPassword()));
        interceptors.add(new LoggingClientHttpRequestInterceptor("com.cts.fasttack"));
        interceptors.add((request, body, execution) -> {
            request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
            return execution.execute(request, body);
        });
        return interceptors;
    }
}
