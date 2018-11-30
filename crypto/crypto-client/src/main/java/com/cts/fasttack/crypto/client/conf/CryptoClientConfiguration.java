package com.cts.fasttack.crypto.client.conf;

import com.cts.fasttack.common.core.rest.jwt.interceptor.JwtClientHttpInterceptor;
import com.cts.fasttack.common.core.rest.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anton Leliuk
 */
@Configuration
public class CryptoClientConfiguration {

    @Autowired
    private JwtService jwtService;

//    @LoadBalanced
    @Bean
    public RestTemplate cryptoServerRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(cryptoServiceInterceptors());
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        return restTemplate;
    }

    @Bean
    public List<ClientHttpRequestInterceptor> cryptoServiceInterceptors(){
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>(1);
        interceptors.add(new JwtClientHttpInterceptor(jwtService, "CRYPTO", 10));
        return interceptors;
    }
}
