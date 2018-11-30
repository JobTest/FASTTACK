package com.cts.fasttack.ih_sv.client.ws.service;

import java.util.function.Supplier;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.handler.ExceptionHandler;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author d.ishchenko
 */
public abstract class WebServiceClient {

	protected WebServiceTemplate webServiceTemplate;

	public WebServiceClient(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

	protected <RESPONSE> RESPONSE executeWithResponse(Supplier<RESPONSE> callback, ExceptionHandler exceptionHandler)
			throws ServiceException {
		try {
			return callback.get();
		} catch (Exception e) {
			return exceptionHandler.handle(e);
		}
	}

}
