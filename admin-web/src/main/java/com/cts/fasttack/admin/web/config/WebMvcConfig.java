package com.cts.fasttack.admin.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebParameters;
import com.cts.fasttack.admin.web.interceptor.ApplicationPropertiesInterceptor;
import com.cts.fasttack.admin.web.service.impl.RandomSequenceGeneratorRepository;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.common.core.web.config.DefaultWebMvcConfigurerAdapter;
import com.cts.fasttack.logging.interceptor.CallingContextInterceptor;
import com.cts.fasttack.logging.service.CallingContext;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends DefaultWebMvcConfigurerAdapter {

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AdminWebParameters adminWebParameters;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CallingContextInterceptor(AdminWebApplication.ORIGINATOR, () -> AdminWebApplication.ORIGINATOR, callingContext));
        registry.addInterceptor(applicationPropertiesInterceptor());

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("/assets/")
                .setCacheControl(CacheControl.empty().mustRevalidate())
                .resourceChain(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("monitoring");
    }

    @Bean
    public ApplicationPropertiesInterceptor applicationPropertiesInterceptor() {
        return new ApplicationPropertiesInterceptor();
    }

    @Bean
    @Primary
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2MessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(JsonUtil.getMVCMapper());
        return mappingJackson2HttpMessageConverter;
    }

    @Bean("templateResolver")
    public ServletContextTemplateResolver servletContextTemplateResolver() {
        ServletContextTemplateResolver servletContextTemplateResolver = new ServletContextTemplateResolver();
        servletContextTemplateResolver.setPrefix("/WEB-INF/pages/");
        servletContextTemplateResolver.setSuffix(".html");
        servletContextTemplateResolver.setCharacterEncoding("UTF-8");
        servletContextTemplateResolver.setTemplateMode("LEGACYHTML5");
        servletContextTemplateResolver.setCacheable(false);
        return servletContextTemplateResolver;
    }

    @Bean("templateEngine")
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(servletContextTemplateResolver());
        springTemplateEngine.setTemplateEngineMessageSource(messageSource);
        springTemplateEngine.setMessageSource(messageSource);
        springTemplateEngine.addDialect(new SpringSecurityDialect());
        springTemplateEngine.addDialect(new LayoutDialect());
        return springTemplateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
        thymeleafViewResolver.setViewClass(ThymeleafView.class);
        thymeleafViewResolver.setContentType("text/html;charset=UTF-8");
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        thymeleafViewResolver.setCache(false);
        return thymeleafViewResolver;
    }

    @Bean
    public RandomSequenceGeneratorRepository randomSequenceGeneratorRepository() {
        return new RandomSequenceGeneratorRepository(adminWebParameters.getRandomSequenceType(), adminWebParameters.getRandomSequenceLength());
    }

}
