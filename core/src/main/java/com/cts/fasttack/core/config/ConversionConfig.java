package com.cts.fasttack.core.config;

import java.util.HashSet;
import java.util.Set;

import com.cts.fasttack.core.converter.StringToTimestampConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

/**
 * @author a.lipavets
 */
@Configuration
public class ConversionConfig {

    @Bean
    public StringToTimestampConverter stringToDeviationConverter(){
        return new StringToTimestampConverter();
    }

    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<StringToTimestampConverter> converters = new HashSet<>();
        converters.add(stringToDeviationConverter());
        conversionServiceFactoryBean.setConverters(converters);
        return conversionServiceFactoryBean;
    }
}
