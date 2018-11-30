package com.cts.fasttack.jms.processor;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import com.cts.fasttack.crypto.client.rest.DatabaseCryptoRestClient;
import com.cts.fasttack.jms.converter.JmsEventMessageToDtoConverter;
import com.cts.fasttack.jms.data.DuplicateDetectionStrategy;
import com.cts.fasttack.jms.data.PersistJmsMessage;
import com.cts.fasttack.jms.service.JmsEventMessageService;

/**
 * Check duplicate message
 *
 * @author Dmitry Koval
 */
public abstract class AbstractIdempotentCamelProcessor extends AbstractCamelProcessor<PersistJmsMessage, Void> {

    public abstract DuplicateDetectionStrategy setDuplicateDetectionStrategy();

    public abstract String setProcessorName();

    @Autowired
    private JmsEventMessageService jmsEventMessageService;

    @Autowired
    private JmsEventMessageToDtoConverter converter;

    @Autowired
    private DatabaseCryptoRestClient databaseCryptoRestClient;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, PersistJmsMessage.class, request -> {
            request.getBody().setMessageHistoryId(request.getMessageHistoryId());
            request.getBody().setProcessorName(setProcessorName());
            request.getBody().setContent(databaseCryptoRestClient.encrypt(request.getBody().getContent()).getText());
            switch (setDuplicateDetectionStrategy()) {
                case CANCEL_PROCESSING:
                    jmsEventMessageService.saveIfNotExists(request.getBody());
                    break;
                case IGNORE_DUBLICATE:
                    jmsEventMessageService.save(converter.convert(request.getBody()));
                    break;
            }
            return null;
        });
    }
}
