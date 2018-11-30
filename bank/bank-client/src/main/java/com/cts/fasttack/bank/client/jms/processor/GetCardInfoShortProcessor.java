package com.cts.fasttack.bank.client.jms.processor;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.client.ws.service.GetCardInfoShortService;
import com.cts.fasttack.jms.dto.GetCardInfoShortJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;

/**
 * Processor for getting card info.
 *
 * @author v.semerkov
 */
@Component
public class GetCardInfoShortProcessor extends AbstractCamelProcessor<GetCardInfoShortJmsMessage, JmsGetCardInfoShortResponseDto> {

    @Autowired
    private GetCardInfoShortService getCardInfoShortService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, GetCardInfoShortJmsMessage.class, request -> getCardInfoShortService.getCardInfoShort(request.getCardInfoShortMessageDto()));
    }
}
