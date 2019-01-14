package com.cts.fasttack.jms.config;

import com.cts.fasttack.common.core.config.PropertyActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

/**
 * JMS configuration.
 *
 * @author v.semerkov
 */
@Configuration
@EnableJms
public class JmsConfiguration {

    private volatile long configuredAt = Long.MAX_VALUE;

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, activeMQConnectionFactory());

        factory.setMaxMessagesPerTask(-1);
        factory.setConcurrency("1-10");
        factory.setSessionAcknowledgeMode(Session.DUPS_OK_ACKNOWLEDGE);
        factory.setCacheLevelName("CACHE_NONE");
        factory.setSessionTransacted(true);

        configuredAt = new Date().getTime();

        return factory;
    }

     /**
      * Connection factory for external JMS instance (ActiveMQ)
      * @see https://programtalk.com/java-api-usage-examples/org.apache.activemq.ActiveMQConnectionFactory
      */
    @Bean
    public ConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(PropertyActiveMQConnectionFactory.BROKER_URL);
        return activeMQConnectionFactory;
    }

//    @Bean
//    public SimpleJmsListenerContainerFactory orderSimpleJmsListenerContainerFactory() {
//        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
//        factory.setConnectionFactory(activeMQConnectionFactory());
//        return factory;
//    }

//    @Bean
//    public DefaultJmsListenerContainerFactory orderDefaultJmsListenerContainerFactory() {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(activeMQConnectionFactory());
//        factory.setConcurrency("3-10");
//        return factory;
//    }

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
