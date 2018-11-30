package com.cts.fasttack.admin.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import com.cts.fasttack.admin.web.config.context.parameter.AdminWebParameters;
import com.cts.fasttack.admin.web.config.context.support.ExposedResourceMessageBundleSource;

@Configuration
public class MessageSourceConfiguration {

    private static final String I18N_PATH = "classpath:i18n/";

    private static final String[] I18N_PATHS = {
            I18N_PATH + "common",
            I18N_PATH + "monitoring",
            I18N_PATH + "feProp",
            I18N_PATH + "login",
            I18N_PATH + "logs",
            I18N_PATH + "roles",
            I18N_PATH + "users",
            I18N_PATH + "validation",
            I18N_PATH + "enckey",
            I18N_PATH + "tokens",
            I18N_PATH + "cardProduct",
            I18N_PATH + "messageHistory",
            I18N_PATH + "errors",
            I18N_PATH + "binSetup"
    };

    @Autowired
    private AdminWebParameters adminWebParameters;

    @Bean("messageSource")
    public ExposedResourceMessageBundleSource messageSource() {
        ExposedResourceMessageBundleSource messageSource = new ExposedResourceMessageBundleSource();
        messageSource.setBasenames(I18N_PATHS);
        return messageSource;
    }

    @Bean("messageSourceAccessor")
    public MessageSourceAccessor messageSourceAccessor() {
        return new MessageSourceAccessor(messageSource(), adminWebParameters.getDefaultLocale());
    }

    @Bean("localeResolver")
    public FixedLocaleResolver fixedLocaleResolver() {
        return new FixedLocaleResolver(adminWebParameters.getDefaultLocale());
    }
}
