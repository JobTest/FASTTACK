package com.cts.fasttack.bank.client.jms.processor;

import com.cts.fasttack.bank.client.ws.service.SearchContragent2WebService;
import com.cts.fasttack.jms.dto.JmsSearchContragent2ResponseDto;
import com.cts.fasttack.jms.dto.SearchContragent2JmsMessage;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class SearchContragent2Processor extends AbstractCamelProcessor<SearchContragent2JmsMessage, JmsSearchContragent2ResponseDto> {

    @Autowired
    private SearchContragent2WebService searchContragent2WebService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, SearchContragent2JmsMessage.class, request -> searchContragent2WebService.searchContragent2(request.getSearchContragent2Dto()));
    }
}
