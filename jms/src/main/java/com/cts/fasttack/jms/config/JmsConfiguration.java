package com.cts.fasttack.jms.config;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.Date;

import javax.jms.ConnectionFactory;

/**
 * JMS configuration.
 *
 * @author v.semerkov
 */
@Configuration
public class JmsConfiguration {

    private volatile long configuredAt = Long.MAX_VALUE;
	
	/**
     * Connection factory for external JMS instance (ActiveMQ)
     */
    @Autowired(required = false)
    @Qualifier("pooledJmsConnectionFactory")
    private PooledConnectionFactory pooledConnectionFactory;

    /**
     * Connection factory for embedded JMS instance (JNDI)
     */
    @Autowired(required = false)
    @Qualifier("connectionFactory")
    private ConnectionFactory connectionFactory;

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, pooledConnectionFactory != null ? pooledConnectionFactory : connectionFactory);

        configuredAt = new Date().getTime();

        return factory;
    }

    /**
     * Serialize message content to json using TextMessage
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    public long getConfiguredAt() {
    	return configuredAt;
    }

}
