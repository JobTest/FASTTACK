package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.converter.CardTokenizedResponseToJmsCardTokenizedResponseDtoConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.CardTokenized;
import com.cts.fasttack.bank.client.ws.client.CardTokenizedResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service("cardTokenizedService")
public class CardTokenizedServiceImpl extends WebServiceClient implements CardTokenizedService {

    @Autowired
    public CardTokenizedServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private CardTokenizedResponseToJmsCardTokenizedResponseDtoConverter cardTokenizedResponseToJmsCardTokenizedResponseDtoConverter;

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE)
    public JmsCardTokenizedResponseDto cardTokenized(CardTokenized requestDto) throws ServiceException {

        return executeWithResponse(() -> cardTokenizedResponseToJmsCardTokenizedResponseDtoConverter.convert(
                        CardTokenizedResponse.class.cast(
                                webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/CardToken", requestDto,
                                        new SoapActionCallback("urn:cardTokenized")))
        ), WebServiceExceptionHandler.INSTANCE);
    }
}
