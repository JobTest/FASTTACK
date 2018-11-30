package com.cts.fasttack.bank.client.jms.processor;

import com.cts.fasttack.bank.client.ws.service.GetUserRolesService;
import com.cts.fasttack.jms.dto.GetUserRolesJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetUserRolesResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserRolesProcessor extends AbstractCamelProcessor<GetUserRolesJmsMessage, JmsGetUserRolesResponseDto> {

    @Autowired
    private GetUserRolesService getUserRolesService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, GetUserRolesJmsMessage.class, request -> getUserRolesService.getUserRoles(request.getJmsGetUserRolesRequestDto()));
    }
}
