package com.cts.fasttack.ih.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.ih.client.config.IssuerHostClientParameters;
import com.cts.fasttack.ih.client.dto.ECommerceConnect;
import com.cts.fasttack.ih.client.exception.IssuerHostServiceExceptionHandler;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

/**
 * @author Anton Leliuk
 */
@Component
public class IssuerHostRestClientImpl extends RestClientImpl implements IssuerHostRestClient {

    @Autowired
    public IssuerHostRestClientImpl(@Qualifier("issuerHostRestTemplate") RestTemplate restTemplate, IssuerHostClientParameters parameters) {
        super(restTemplate, parameters.getAddress());
    }

    @Override
    @MessageHistoryOperation(connectorClient = "AUTH", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE,
            maskedPan = "#request != null &&  #request.message != null && #request.message.getXMLPayRequest() != null && #request.message.getXMLPayRequest().requestData != null && #request.message.getXMLPayRequest().requestData.transactions != null && #request.message.getXMLPayRequest().requestData.transactions.transaction[0] != null && #request.message.getXMLPayRequest().requestData.transactions.transaction[0].authorization != null && #request.message.getXMLPayRequest().requestData.transactions.transaction[0].authorization.payData != null && #request.message.getXMLPayRequest().requestData.transactions.transaction[0].authorization.payData.card != null && #request.message.getXMLPayRequest().requestData.transactions.transaction[0].authorization.payData.card.cardNum != null ? T(com.cts.fasttack.common.core.util.StringUtil).displayPanOrToken(#request.message.getXMLPayRequest().requestData.transactions.transaction[0].authorization.payData.card.cardNum.toString()) : null",
            decision = "(#result != null && #result.message != null && #result.message.getXMLPayResponse() != null && #result.message.getXMLPayResponse().responseData != null && #result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0] != null) ? ((\"000\").equals(#result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0].hostCode)&&(\"M\").equals(#result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0].getCVResult()) ? (\"SUCCESS\") : (\"DECLINE\")) : null",
            errorCode = "(#result != null && #result.message != null && #result.message.getXMLPayResponse() != null && #result.message.getXMLPayResponse().responseData != null && #result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0] != null) ? (#result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0].tranCode) : null",
            cvcResp = "(#result != null && #result.message != null && #result.message.getXMLPayResponse() != null && #result.message.getXMLPayResponse().responseData != null && #result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0] != null && #result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0].getCVResult() != null) ? ((\"M\").equals(#result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0].getCVResult()) ? \"M\" : (\"N\").equals(#result.message.getXMLPayResponse().responseData.transactionResults.transactionResult[0].getCVResult()) ? \"N\" : \"P\") : null")
    public ECommerceConnect accountStatusVerification(ECommerceConnect request) throws ServiceException {
        return post("/", request, ECommerceConnect.class, IssuerHostServiceExceptionHandler.INSTANCE);
    }
}
