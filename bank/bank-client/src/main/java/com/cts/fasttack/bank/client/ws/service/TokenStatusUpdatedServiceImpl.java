package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.converter.TokenStatusUpdatedResponseToBankJmsResponseDtoConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.TokenStatusUpdated;
import com.cts.fasttack.bank.client.ws.client.TokenStatusUpdatedResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service("tokenStatusUpdatedService")
public class TokenStatusUpdatedServiceImpl extends WebServiceClient implements TokenStatusUpdatedService {

    @Autowired
    public TokenStatusUpdatedServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private TokenStatusUpdatedResponseToBankJmsResponseDtoConverter tokenStatusUpdatedResponseToBankJmsResponseDtoConverter;

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE)
    public BankJmsResponseDto tokenStatusUpdated(TokenStatusUpdated requestDto) throws ServiceException {
        return executeWithResponse(() -> tokenStatusUpdatedResponseToBankJmsResponseDtoConverter.convert(
                        TokenStatusUpdatedResponse.class.cast(
                                webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/CardToken", requestDto,
                                        new SoapActionCallback("urn:tokenStatusUpdated")))
        ), WebServiceExceptionHandler.INSTANCE);
    }
}
