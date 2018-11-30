package com.cts.fasttack.common.core.web.config;

import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configure default content negotiation
 * @author Anton Leliuk
 */
public class DefaultWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(false)
                .favorPathExtension(false)
                .favorParameter(false);
    }
}
