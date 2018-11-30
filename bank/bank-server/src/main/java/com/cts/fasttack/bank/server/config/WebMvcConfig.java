package com.cts.fasttack.bank.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.cts.fasttack.bank.common.Constants;
import com.cts.fasttack.common.core.web.config.DefaultWebMvcConfigurerAdapter;
import com.cts.fasttack.logging.interceptor.CallingContextInterceptor;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.logging.web.filter.LoggingHttpRequestFilter;

/**
 * @author Anton Leliuk
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends DefaultWebMvcConfigurerAdapter {

    @Autowired
    private CallingContext callingContext;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CallingContextInterceptor(Constants.ORIGINATOR, () -> Constants.ORIGINATOR, callingContext));
    }

    @Bean
    public LoggingHttpRequestFilter requestLoggingFilter() {
        return new LoggingHttpRequestFilter(Constants.ORIGINATOR, "fasttack-bank-server-tracing");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:errors");
        return messageSource;
    }
}
