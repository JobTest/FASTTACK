package com.cts.fasttack.core.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

import com.cts.fasttack.common.core.config.DecryptingPropertySourceFactory;

@EnableDiscoveryClient(autoRegister = false)
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "com.cts.fasttack")
@PropertySource(value = "classpath:fasttack-core-application.properties", ignoreResourceNotFound = true, factory = DecryptingPropertySourceFactory.class)
@PropertySource(value = "file:${catalina.home}/conf/fasttack-core-application.properties", ignoreResourceNotFound = true, factory = DecryptingPropertySourceFactory.class)
@PropertySource(value = "file:${jboss.home.dir}/standalone/configuration/fasttack-core-application.properties", ignoreResourceNotFound = true, factory = DecryptingPropertySourceFactory.class)
@PropertySource(value = "file:${fasttack.home.dir}/conf/fasttack-core-application.properties", ignoreResourceNotFound = true, factory = DecryptingPropertySourceFactory.class)
public class CoreApplication {

	public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
	}
}
