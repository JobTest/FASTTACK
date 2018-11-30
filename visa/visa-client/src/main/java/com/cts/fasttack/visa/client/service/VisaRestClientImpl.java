package com.cts.fasttack.visa.client.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.logging.interceptor.MessageHistoryInterceptor;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import com.cts.fasttack.visa.client.config.VisaConnectionParameters;
import com.cts.fasttack.visa.client.dto.PingRequestDto;
import com.cts.fasttack.visa.client.dto.PingResponseDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryRequestDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryResponseDto;
import com.cts.fasttack.visa.client.dto.TokenLifecycleRequestDto;
import com.cts.fasttack.visa.client.dto.TokenLifecycleResponseDto;
import com.cts.fasttack.visa.client.exception.VisaExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Anton Leliuk
 */
@Service
public class VisaRestClientImpl extends RestClientImpl implements VisaRestClient {

    @Autowired
    public VisaRestClientImpl(@Qualifier("visaClientRestTemplate") RestTemplate restTemplate, VisaConnectionParameters parameters) {
        super(restTemplate, parameters.getAddress());
    }

    @MessageHistoryOperation(connectorClient = "VISA", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE)
    @Override
    public PingResponseDto ping(PingRequestDto request) throws ServiceException {
        return post(PING_ENDPOINT, request, PingResponseDto.class, VisaExceptionHandler.INSTANCE);
    }

    @MessageHistoryOperation(connectorClient = "VISA", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE,
            tokenId = "#request != null ? #request.tokenReferenceID : null")
    @Override
    public TokenLifecycleResponseDto tokenLifecycle(TokenLifecycleRequestDto request) throws ServiceException {
        request.setRequestID(MessageHistoryInterceptor.PARENT_ID.get().toString());
        return post(TOKEN_ACTIVATE_ENDPOINT, request, TokenLifecycleResponseDto.class, VisaExceptionHandler.INSTANCE);
    }

    @MessageHistoryOperation(connectorClient = "VISA", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE,
            tokenId = "#request != null ? #request.tokenReferenceID : null")
    @Override
    public TokenInquiryResponseDto tokenInquiry(TokenInquiryRequestDto request) throws ServiceException {
        return post(TOKEN_INQUIRY_ENDPOINT, request, TokenInquiryResponseDto.class, VisaExceptionHandler.INSTANCE);
    }
}
