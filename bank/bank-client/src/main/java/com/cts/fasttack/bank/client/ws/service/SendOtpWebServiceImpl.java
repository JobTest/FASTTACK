package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.converter.SendOtpResponseToDtoConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.ObjectFactory;
import com.cts.fasttack.bank.client.ws.client.SendOTP;
import com.cts.fasttack.bank.client.ws.client.SendOTPResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import com.cts.fasttack.jms.dto.JmsSendOtpDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.apache.commons.lang3.StringUtils;

/**
 * @author a.lipavets
 */
@Service
public class SendOtpWebServiceImpl extends WebServiceClient implements SendOtpWebService {

    @Autowired
    public SendOtpWebServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private SendOtpResponseToDtoConverter sendOtpResponseToDtoConverter;

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE,
            panInternalId = "#request != null ? #request.panInternalId : null",
            panInternalGuid = "#request != null ? #request.panInternalGuid : null", errorCode = "!(\"0\").equals(#result.code) ? #result.code : null",
            tokenId = "#request != null ? #request.tokenRefId : null",
            maskedPan = "#request != null ? #request.maskedPan : null")
    public BankJmsResponseDto sendOtp(JmsSendOtpDto request) throws ServiceException {
        SendOTP wsRequest = OBJECT_FACTORY.createSendOTP();
        wsRequest.setConversationId(OBJECT_FACTORY.createConversationId(request.getConversationId()));
        wsRequest.setCustomerPhone(OBJECT_FACTORY.createCustomerPhone(request.getCustomerPhone()));
        wsRequest.setOtp(OBJECT_FACTORY.createOtp(request.getOtp()));
        wsRequest.setPanInternalGUID(request.getPanInternalGuid());
        wsRequest.setPanInternalId(request.getPanInternalId());
        wsRequest.setRequestId(OBJECT_FACTORY.createRequestId(request.getRequestId()));
        if (StringUtils.isNotBlank(request.getDeviceType())) wsRequest.setDeviceType(OBJECT_FACTORY.createDeviceType(request.getDeviceType()));
        if (StringUtils.isNotBlank(request.getTokenRefId())) wsRequest.setTokenRefId(OBJECT_FACTORY.createTokenRefId(request.getTokenRefId()));
        if (StringUtils.isNotBlank(request.getTokenRequestorId())) wsRequest.setTokenRequestorId(OBJECT_FACTORY.createTokenRequestorId(request.getTokenRequestorId()));
        if (StringUtils.isNotBlank(request.getLastFourOfPAN())) wsRequest.setLastFourOfPAN(OBJECT_FACTORY.createLastFourOfPAN(request.getLastFourOfPAN()));



        return executeWithResponse(() -> sendOtpResponseToDtoConverter.convert(
                        SendOTPResponse.class.cast(
                                webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/CardToken", wsRequest,
                                        new SoapActionCallback("urn:sendOTP")))
        ), WebServiceExceptionHandler.INSTANCE);
    }
}
