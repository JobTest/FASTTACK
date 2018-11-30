package com.cts.fasttack.bank.client.ws.service;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import com.cts.fasttack.bank.client.converter.GetCustomerIDResponseToDtoConverter;
import com.cts.fasttack.bank.client.converter.JmsGetCustomerIDMessageDtoToGetCustomerIDConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCustomerID;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCustomerIDResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDMessageDto;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

/**
 * Service for getting customer ID.
 *
 * @author v.semerkov
 */
@Service
public class GetCustomerIDServiceImpl extends WebServiceClient implements GetCustomerIDService {

    @Autowired
    public GetCustomerIDServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private JmsGetCustomerIDMessageDtoToGetCustomerIDConverter jmsGetCustomerIDMessageDtoToGetCustomerIDConverter;

    @Autowired
    private GetCustomerIDResponseToDtoConverter getCustomerIDResponseToDtoConverter;

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.cardNum)")
    public JmsGetCustomerIDResponseDto getCustomerID(JmsGetCustomerIDMessageDto request) throws ServiceException {
        GetCustomerID wsRequest = jmsGetCustomerIDMessageDtoToGetCustomerIDConverter.convert(request);

        return executeWithResponse(() -> {
            @SuppressWarnings("unchecked")
			GetCustomerIDResponse response = ((JAXBElement<GetCustomerIDResponse>) webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/CardPT", wsRequest, new SoapActionCallback("urn:getCustomerID"))).getValue();
            return getCustomerIDResponseToDtoConverter.convert(response);
        }, WebServiceExceptionHandler.INSTANCE);
    }
}
