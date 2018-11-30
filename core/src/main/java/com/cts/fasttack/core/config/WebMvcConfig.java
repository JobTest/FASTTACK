package com.cts.fasttack.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.cts.fasttack.common.core.rest.jwt.interceptor.JwtServerHttpInterceptor;
import com.cts.fasttack.common.core.rest.jwt.service.JwtService;
import com.cts.fasttack.common.core.web.config.DefaultWebMvcConfigurerAdapter;
import com.cts.fasttack.core.Constants;
import com.cts.fasttack.logging.interceptor.CallingContextInterceptor;
import com.cts.fasttack.logging.service.CallingContext;

/**
 * @author Anton Leliuk
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends DefaultWebMvcConfigurerAdapter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CallingContext callingContext;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CallingContextInterceptor(Constants.ORIGINATOR, () -> Constants.ORIGINATOR, callingContext));
        registry.addInterceptor(new JwtServerHttpInterceptor(jwtService)).addPathPatterns("/secured/**");
    }

    @Bean
    @Primary
    public Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:errors");
        return messageSource;
    }
}
