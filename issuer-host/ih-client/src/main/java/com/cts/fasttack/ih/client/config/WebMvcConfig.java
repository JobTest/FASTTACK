package com.cts.fasttack.ih.client.config;

import com.cts.fasttack.common.core.web.config.DefaultWebMvcConfigurerAdapter;
import com.cts.fasttack.logging.interceptor.CallingContextInterceptor;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.logging.web.filter.LoggingHttpRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @author Anton Leliuk
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends DefaultWebMvcConfigurerAdapter {

    private static final String ORIGINATOR = "AUTH";
    @Autowired
    private CallingContext callingContext;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CallingContextInterceptor(ORIGINATOR, () -> ORIGINATOR, callingContext));
    }

    @Bean
    public LoggingHttpRequestFilter requestLoggingFilter() {
        return new LoggingHttpRequestFilter(ORIGINATOR, "fasttack-issuer-host-client-tracing");
    }
}
