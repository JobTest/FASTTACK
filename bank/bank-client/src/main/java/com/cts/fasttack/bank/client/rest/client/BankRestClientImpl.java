package com.cts.fasttack.bank.client.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.bank.client.config.BankClientParameters;
import com.cts.fasttack.bank.client.exception.BankClientExceptionHandler;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.jms.dto.JmsCardTokenizedRequestDto;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenStatusUpdatedDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

@Component
public class BankRestClientImpl extends RestClientImpl implements BankRestClient {

    @Autowired
    public BankRestClientImpl(@Qualifier("bankClientHostRestTemplate") RestTemplate restTemplate, BankClientParameters parameters) {
        super(restTemplate, parameters.getAddress());
    }

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.pan)",
            panInternalId = "#request != null ? #request.panInternalId : null", panInternalGuid = "#request != null ? #request.panInternalGUID : null",
            panSource = "#request.panSource",
            tokenId = "#request != null ? #request.tokenRefId : null")
    public JmsCardTokenizedResponseDto cardTokenized(JmsCardTokenizedRequestDto request) throws ServiceException {
        return post("/cardTokenized", request, JmsCardTokenizedResponseDto.class, BankClientExceptionHandler.INSTANCE);
    }


    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request",
            panInternalId = "#request != null ? #request.panInternalId : null", panInternalGuid = "#request != null ? #request.panInternalGuid : null",
            tokenId = "#request != null ? #request.tokenRefId : null")
    public void tokenStatusUpdated(JmsTokenStatusUpdatedDto request) throws ServiceException {
        post("/tokenStatusUpdated", request, Void.class, BankClientExceptionHandler.INSTANCE);
    }
}
