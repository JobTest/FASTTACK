package com.cts.fasttack.crypto.server.conf;

import com.cts.fasttack.common.core.rest.jwt.interceptor.JwtServerHttpInterceptor;
import com.cts.fasttack.common.core.rest.jwt.service.JwtService;
import com.cts.fasttack.common.core.web.config.DefaultWebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @author Anton Leliuk
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends DefaultWebMvcConfigurerAdapter {

    @Autowired
    private JwtService jwtService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtServerHttpInterceptor(jwtService)).addPathPatterns("/secured/*");
    }
}
