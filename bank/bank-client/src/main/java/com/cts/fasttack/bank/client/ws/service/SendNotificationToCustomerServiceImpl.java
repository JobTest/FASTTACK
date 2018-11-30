package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.converter.JmsSendNotificationToCustomerDtoToDomainConverter;
import com.cts.fasttack.bank.client.converter.SendNotificationToCustomerResponseToJmsSendNotificationToCustomerResponseDtoConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.SendNotificationToCustomer;
import com.cts.fasttack.bank.client.ws.client.SendNotificationToCustomerResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerRequestDto;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service("sendNotificationToCustomerService")
public class SendNotificationToCustomerServiceImpl extends WebServiceClient implements SendNotificationToCustomerService {

    @Autowired
    public SendNotificationToCustomerServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private JmsSendNotificationToCustomerDtoToDomainConverter jmsSendNotificationToCustomerDtoToDomainConverter;

    @Autowired
    private SendNotificationToCustomerResponseToJmsSendNotificationToCustomerResponseDtoConverter sendNotificationToCustomerResponseToJmsSendNotificationToCustomerResponseDtoConverter;

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE)
    public JmsSendNotificationToCustomerResponseDto sendNotificationToCustomer(JmsSendNotificationToCustomerRequestDto requestDto) throws ServiceException {
        SendNotificationToCustomer request = jmsSendNotificationToCustomerDtoToDomainConverter.convert(requestDto);
        return executeWithResponse(() -> sendNotificationToCustomerResponseToJmsSendNotificationToCustomerResponseDtoConverter.convert(
                SendNotificationToCustomerResponse.class.cast(
                                webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/CardToken", request,
                                        new SoapActionCallback("urn:sendNotificationToCustomer")))
        ), WebServiceExceptionHandler.INSTANCE);
    }
}
