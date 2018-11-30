package com.cts.fasttack.bank.client.rest.client;

import com.cts.fasttack.bank.client.converter.JmsCardTokenizedDtoToDomainConverter;
import com.cts.fasttack.bank.client.converter.JmsTokenStatusUpdatedDtoToDomainConverter;
import com.cts.fasttack.bank.client.ws.client.CardTokenized;
import com.cts.fasttack.bank.client.ws.client.TokenStatusUpdated;
import com.cts.fasttack.bank.client.ws.service.CardTokenizedService;
import com.cts.fasttack.bank.client.ws.service.TokenStatusUpdatedService;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedRequestDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenStatusUpdatedDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankSoapClientImpl implements BankSoapClient {

    @Autowired
    private CardTokenizedService cardTokenizedService;

    @Autowired
    private TokenStatusUpdatedService tokenStatusUpdatedService;

    @Autowired
    private JmsCardTokenizedDtoToDomainConverter jmsCardTokenizedDtoToDomainConverter;

    @Autowired
    private JmsTokenStatusUpdatedDtoToDomainConverter jmsTokenStatusUpdatedDtoToDomainConverter;

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.pan)",
            panInternalId = "#request != null ? #request.panInternalId : null", panInternalGuid = "#request != null ? #request.panInternalGUID : null",
            panSource = "#request.panSource",
            tokenId = "#request != null ? #request.tokenRefId : null")
    public JmsCardTokenizedResponseDto cardTokenized(JmsCardTokenizedRequestDto request) throws ServiceException {
        CardTokenized requestDto = jmsCardTokenizedDtoToDomainConverter.convert(request);
        return cardTokenizedService.cardTokenized(requestDto);
    }


    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request",
            panInternalId = "#request != null ? #request.panInternalId : null", panInternalGuid = "#request != null ? #request.panInternalGuid : null",
            tokenId = "#request != null ? #request.tokenRefId : null")
    public BankJmsResponseDto tokenStatusUpdated(JmsTokenStatusUpdatedDto request) throws ServiceException {
        TokenStatusUpdated requestDto = jmsTokenStatusUpdatedDtoToDomainConverter.convert(request);
        return tokenStatusUpdatedService.tokenStatusUpdated(requestDto);
    }
}
