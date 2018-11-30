package com.cts.fasttack.jms.support;

import java.util.Date;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.ExchangeTimedOutException;
import org.apache.camel.ProducerTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.data.ProcessingArea;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.crypto.client.rest.JmsCryptoRestClient;
import com.cts.fasttack.jms.config.JmsConfiguration;
import com.cts.fasttack.jms.data.JmsMessage;
import com.cts.fasttack.jms.data.JmsResponseMessage;
import com.cts.fasttack.logging.interceptor.MessageHistoryInterceptor;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Публикует сообщения в указанный JMS topic в рамках паттерна Publisher-Subscriber.
 * Сообщения преобразуются в JSON.
 */
@Component
public class IntegrationBus {

    private static final String GLOBAL_QUEUE_PREFIX = "FASTTACK";

    public static final String CLUSTER_INSTANCE_HEADER_KEY = "jms.cluster.instance";

    private static final Logger log = LogManager.getLogger(IntegrationBus.class);

    @Autowired
    @Qualifier("producerTemplate")
    private ProducerTemplate producerTemplate;

    @Value("${spring.jms.inOut.requestTimeoutInMills}")
    private int requestTimeout;

    @Value("${spring.jms.inOut.timeToLiveInMills}")
    private int timeToLive;

    @Autowired
    private JmsCryptoRestClient jmsCryptoRestClient;

    @Autowired
    private JmsConfiguration jmsConfiguration;

    private final static long delayAfterJmsConfig = 30000L;
    
    public void publish(String topic, JmsMessage message) throws ServiceException {
        message.setMessageHistoryId(MessageHistoryInterceptor.PARENT_ID.get());

    	if (new Date().getTime() - delayAfterJmsConfig < jmsConfiguration.getConfiguredAt()) {
    		throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, "JMS configuration not yet finished");
    	}

    	String messageJson = JsonUtil.toJson(message);
        producerTemplate.sendBodyAndHeaders("jms:topic:" + topic, jmsCryptoRestClient.encrypt(messageJson).getText(), message.getHeaders());
    }

    public <T> T inOut(ProcessingArea area, String queue, JmsMessage message, Class<T> responseClass) throws ServiceException {
        if(message.getMessageHistoryId() == null) {
            message.setMessageHistoryId(MessageHistoryInterceptor.PARENT_ID.get());
        }

        StringBuilder fullQueueName = new StringBuilder(GLOBAL_QUEUE_PREFIX).append(".").append(area.name()).append(".").append(queue);
        try {
        	if (new Date().getTime() - delayAfterJmsConfig < jmsConfiguration.getConfiguredAt()) {
        		throw ServiceException.withDescription(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, "JMS configuration not yet finished");
        	}

        	String messageJson = JsonUtil.toJson(message);
            String encryptedJson = jmsCryptoRestClient.encrypt(messageJson).getText();
            if (log.isDebugEnabled()) {
                log.debug("Sending inOut request to queue '" + fullQueueName + "' with message: " + encryptedJson);
            }
            String encryptedResult = producerTemplate.requestBody("jms:" + fullQueueName.toString() + "?exchangePattern=InOut&requestTimeout=" + requestTimeout + "&timeToLive=" + timeToLive
                    + "&asyncConsumer=true&asyncStartListener=true&concurrentConsumers=10"
                    + "&useMessageIDAsCorrelationID=true", encryptedJson, String.class);

            if (log.isDebugEnabled()) {
                log.debug("Received response from queue '" + fullQueueName + "': " + encryptedResult);
            }
            String result = jmsCryptoRestClient.decrypt(encryptedResult).getText();
            JmsResponseMessage<T> response = JsonUtil.fromJson(result, TypeFactory.defaultInstance().constructParametricType(JmsResponseMessage.class, responseClass));
            if (response.isError()) {
                throw new ServiceException(response.getErrorCode(), response.getHttpStatus(), response.getParams());
            }
            return response.getRawMessage();
        } catch (CamelExecutionException e) {
            if (e.getCause() != null && e.getCause().getClass() == ExchangeTimedOutException.class) {
                log.error("Message processing timeout exceeded for the queue '" + fullQueueName + "'. " +
                        "The corresponding processor doesn't exist or is too busy.", e);
            } else {
                log.error("Error in async processing on the queue '" + fullQueueName + "'", e);
            }
            throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
        }
    }
}
