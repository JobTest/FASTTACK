package com.cts.fasttack.ih_sv.client.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.ih_sv.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.ih_sv.client.ws.client.Avs1Request;
import com.cts.fasttack.ih_sv.client.ws.client.Avs1Response;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;

/**
 * @author d.ishchenko
 */
@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Avs1ServiceImpl extends WebServiceClient implements Avs1Service {

    @Value("${spring.client.ws.avs1SoapAction}")
    private String avs1SoapAction;

	@Autowired
	public Avs1ServiceImpl(@Qualifier("webServiceTemplate") WebServiceTemplate webServiceTemplate) {
		super(webServiceTemplate);
	}

	@Override
	@MessageHistoryOperation(connectorClient = "AUTH", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE, maskedPan = "#maskedPan", decision = "#result != null && #result.code != null ? (\"000\".equals(#result.code.value) ? \"SUCCESS\" : \"DECLINE\") : null", cvcResp = "#result != null && #result.code != null ? (\"000\".equals(#result.code.value) ? \"M\" : (\"001\".equals(#result.code.value) ? \"N\" : \"P\")) : null", errorCode = "#result.code != null ? #result.code.value : null")
	public Avs1Response avs1(Avs1Request request, String maskedPan) throws ServiceException {
		return executeWithResponse(
				() -> Avs1Response.class.cast(webServiceTemplate.marshalSendAndReceive(
						webServiceTemplate.getDefaultUri(), request, new SoapActionCallback(avs1SoapAction))),
				WebServiceExceptionHandler.INSTANCE);
	}

}
