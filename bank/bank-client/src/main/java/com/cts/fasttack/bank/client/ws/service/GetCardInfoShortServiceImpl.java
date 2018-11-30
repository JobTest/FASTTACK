package com.cts.fasttack.bank.client.ws.service;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import com.cts.fasttack.bank.client.converter.GetCardInfoShortResponseToJmsGetCardInfoShortResponseDtoConverter;
import com.cts.fasttack.bank.client.converter.JmsGetCardInfoShortMessageDtoToGetCardInfoShortConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCardInfoShort;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCardInfoShortResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

/**
 * Service for getting card info.
 *
 * @author v.semerkov
 */
@Service
public class GetCardInfoShortServiceImpl extends WebServiceClient implements GetCardInfoShortService {

    @Autowired
    public GetCardInfoShortServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private JmsGetCardInfoShortMessageDtoToGetCardInfoShortConverter jmsGetCardInfoShortMessageDtoToGetCardInfoShortConverter;

    @Autowired
    private GetCardInfoShortResponseToJmsGetCardInfoShortResponseDtoConverter getCardInfoShortResponseToJmsGetCardInfoShortResponseDtoConverter;

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE,
            maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.pan)",
            panInternalId = "#result != null ? #result.cardID : null",
            panInternalGuid = "#result != null ? #result.cardGUID : null")
    public JmsGetCardInfoShortResponseDto getCardInfoShort(JmsGetCardInfoShortMessageDto request) throws ServiceException {
        GetCardInfoShort wsRequest = jmsGetCardInfoShortMessageDtoToGetCardInfoShortConverter.convert(request);

        return executeWithResponse(() -> {
            @SuppressWarnings("unchecked")
			GetCardInfoShortResponse response = ((JAXBElement<GetCardInfoShortResponse>) webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/CardPT", wsRequest, new SoapActionCallback("urn:getCardInfoShort"))).getValue();
            return getCardInfoShortResponseToJmsGetCardInfoShortResponseDtoConverter.convert(response);
        }, WebServiceExceptionHandler.INSTANCE);
    }
}
