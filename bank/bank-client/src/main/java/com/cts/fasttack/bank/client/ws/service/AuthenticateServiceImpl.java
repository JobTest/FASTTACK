package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.converter.AuthenticateResponseToJmsAuthenticateResponseDtoConverter;
import com.cts.fasttack.bank.client.converter.JmsAuthenticateDtoToDomainConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.Authenticate;
import com.cts.fasttack.bank.client.ws.client.AuthenticateResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsAuthenticateRequestDto;
import com.cts.fasttack.jms.dto.JmsAuthenticateResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service("authenticateService")
public class AuthenticateServiceImpl extends WebServiceClient implements AuthenticateService {

    @Autowired
    public AuthenticateServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private JmsAuthenticateDtoToDomainConverter jmsAuthenticateDtoToDomainConverter;

    @Autowired
    private AuthenticateResponseToJmsAuthenticateResponseDtoConverter authenticateResponseToJmsAuthenticateResponseDtoConverter;

    @Override
    public JmsAuthenticateResponseDto authenticate(JmsAuthenticateRequestDto requestDto) throws ServiceException {
        Authenticate request = jmsAuthenticateDtoToDomainConverter.convert(requestDto);
        return executeWithResponse(() -> authenticateResponseToJmsAuthenticateResponseDtoConverter.convert(
                AuthenticateResponse.class.cast(
                                webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/Authentication", request,
                                        new SoapActionCallback("urn:authenticate")))
        ), WebServiceExceptionHandler.INSTANCE);
    }
}
