package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.client.ConfirmProvisioning;
import com.cts.fasttack.bank.client.ws.client.ConfirmProvisioningResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * @author Dmitry Koval
 */
@Service("confirmProvisioningService")
public class ConfirmProvisioningServiceImpl extends WebServiceClient implements ConfirmProvisioningService {

    @Autowired
    public ConfirmProvisioningServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#requestDto", responseMediaType = MediaType.APPLICATION_XML_VALUE,
            panSource = "#requestDto.panSource",
            maskedPan = "T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#requestDto.pan)",
            errorCode = "#result.code != null ? #result.code.value : null",
            decision = "#result.decision != null ? #result.decision.value : null",
            panInternalId = "#result != null && #result.panInternalId != null ? #result.panInternalId.value : null",
            panInternalGuid = "#result != null && #result.panInternalGUID != null ? #result.panInternalGUID.value : null",
            tokenId = "#request != null ? #request.tokenRefId : null")
    public ConfirmProvisioningResponse confirmProvisioning(ConfirmProvisioning requestDto) throws ServiceException {
        return executeWithResponse(() ->
                        ConfirmProvisioningResponse.class.cast(
                                webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/CardToken", requestDto,
                                        new SoapActionCallback("urn:confirmProvisioning"))),
                WebServiceExceptionHandler.INSTANCE);
    }
}
