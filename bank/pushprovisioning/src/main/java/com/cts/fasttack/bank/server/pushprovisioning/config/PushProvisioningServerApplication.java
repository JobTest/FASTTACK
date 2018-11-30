package com.cts.fasttack.bank.server.pushprovisioning.config;

import com.cts.fasttack.common.core.config.DecryptingPropertySourceFactory;
import com.cts.fasttack.visa.common.exception.VisaExceptionHandlerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Anton Leliuk
 */
@EnableDiscoveryClient(autoRegister = false)
@EnableConfigurationProperties
@SpringBootApplication
@ComponentScan(basePackages = "com.cts.fasttack", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {VisaExceptionHandlerController.class})
})
@PropertySource(value = "classpath:fasttack-bank-pushprovisioning-application.properties", ignoreResourceNotFound = true, factory = DecryptingPropertySourceFactory.class)
@PropertySource(value = "file:${catalina.home}/conf/fasttack-bank-pushprovisioning-application.properties", ignoreResourceNotFound = true, factory = DecryptingPropertySourceFactory.class)
@PropertySource(value = "file:${jboss.home.dir}/standalone/configuration/fasttack-bank-pushprovisioning-application.properties", ignoreResourceNotFound = true, factory = DecryptingPropertySourceFactory.class)
@PropertySource(value = "file:${fasttack.home.dir}/conf/fasttack-bank-pushprovisioning-application.properties", ignoreResourceNotFound = true, factory = DecryptingPropertySourceFactory.class)
public class PushProvisioningServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PushProvisioningServerApplication.class, args);
    }
}
