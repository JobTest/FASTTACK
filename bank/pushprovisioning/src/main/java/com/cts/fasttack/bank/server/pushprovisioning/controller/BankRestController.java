package com.cts.fasttack.bank.server.pushprovisioning.controller;

import com.cts.fasttack.bank.server.pushprovisioning.converter.GetTokenByWalletIdRequestDtoToJmsGetTokenByWalletIdMessageDtoConverter;
import com.cts.fasttack.bank.server.pushprovisioning.converter.JmsGetTokenByWalletIdResponseDtoToGetTokenByWalletIdResponseDtoConverter;
import com.cts.fasttack.bank.server.pushprovisioning.dto.GetTokenByWalletIdRequestDto;
import com.cts.fasttack.bank.server.pushprovisioning.dto.GetTokenByWalletIdResponseDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.GetTokenByWalletIdJmsMessage;
import com.cts.fasttack.jms.dto.JmsGetTokenByWalletIdResponseDto;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import com.cts.fasttack.logging.service.CallingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bank REST controller.
 *
 * @author v.semerkov
 */
@RestController
public class BankRestController {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private GetTokenByWalletIdRequestDtoToJmsGetTokenByWalletIdMessageDtoConverter getTokenByWalletIdRequestDtoToJmsGetTokenByWalletIdMessageDtoConverter;

    @Autowired
    private JmsGetTokenByWalletIdResponseDtoToGetTokenByWalletIdResponseDtoConverter jmsGetTokenByWalletIdResponseDtoToGetTokenByWalletIdResponseDtoConverter;

    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE)
    @PostMapping("/getTokenByWalletId")
    public GetTokenByWalletIdResponseDto getTokenByWalletId(@Validated @RequestBody GetTokenByWalletIdRequestDto request) throws ServiceException {
        HeadersJmsMessage jmsMessage = new GetTokenByWalletIdJmsMessage()
                .tokenByWalletIdMessageDto(getTokenByWalletIdRequestDtoToJmsGetTokenByWalletIdMessageDtoConverter.convert(request))
                .originator(callingContext.getOriginator());
        JmsGetTokenByWalletIdResponseDto jmsGetTokenByWalletIdResponseDto = integrationBus.inOut(callingContext.getProcessingArea(), "listTokensByWalletId", jmsMessage, JmsGetTokenByWalletIdResponseDto.class);

        return jmsGetTokenByWalletIdResponseDtoToGetTokenByWalletIdResponseDtoConverter.convert(jmsGetTokenByWalletIdResponseDto);
    }

}
