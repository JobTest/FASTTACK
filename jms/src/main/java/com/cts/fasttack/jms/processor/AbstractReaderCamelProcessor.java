package com.cts.fasttack.jms.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.cts.fasttack.crypto.client.rest.DatabaseCryptoRestClient;
import com.cts.fasttack.jms.converter.JmsEventMessageToDtoConverter;
import com.cts.fasttack.jms.data.JmsEventMessage;
import com.cts.fasttack.jms.dto.JmsEventMessageDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryInterceptor;

/**
 * For process {@link JmsEventMessage}
 *
 * @author Dmitry Koval
 */
public abstract class AbstractReaderCamelProcessor implements Processor {

    public abstract void process(JmsEventMessageDto eventMessage) throws Exception;

    protected final Logger log = LogManager.getLogger(getClass());

    @Value("${camel.message.queue.replay.count}")
    protected int count;

    @Autowired
    private DatabaseCryptoRestClient databaseCryptoRestClient;

    @Autowired
    private JmsEventMessageToDtoConverter jmsEventMessageToDtoConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        JmsEventMessage eventMessage = (JmsEventMessage) exchange.getIn().getBody();
        MessageHistoryInterceptor.PARENT_ID.set(eventMessage.getMessageHistoryId());
        if (eventMessage.getNumberOfDeliveryAttempts() < count) {
            eventMessage.setNumberOfDeliveryAttempts(eventMessage.getNumberOfDeliveryAttempts() + 1);

            JmsEventMessageDto dto = jmsEventMessageToDtoConverter.convert(eventMessage);
            dto.setContent(databaseCryptoRestClient.decrypt(dto.getContent()).getText());
            process(dto);
        } else {
            log.info("Message not processed");
        }
    }
}
