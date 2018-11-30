package com.cts.fasttack.ih_sv.client.exception;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.exception.handler.ServiceExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.WebServiceIOException;

/**
 * @author d.ishchenko
 */
public class WebServiceExceptionHandler extends ServiceExceptionHandler {

	public static final WebServiceExceptionHandler INSTANCE = new WebServiceExceptionHandler();

	@Override
	public <RESPONSE> RESPONSE handle(Exception e) throws ServiceException {
		if (log.isDebugEnabled()) {
			log.debug("Handling exception " + e.getClass() + " - " + e.getMessage());
		}
		if (e instanceof WebServiceClientException) {
			log.warn("Can not call Web service - SOAP fault occurred", e);
			if (e instanceof WebServiceIOException) {
				WebServiceIOException webIoEx = (WebServiceIOException) e;
				if (webIoEx.getRootCause() instanceof ConnectException
						|| webIoEx.getRootCause() instanceof SocketTimeoutException) {
					throw new ServiceException(StandardErrorCodes.HOST_TIMEOUT, HttpStatus.SERVICE_UNAVAILABLE);
				}
				throw new ServiceException(StandardErrorCodes.HOST_NOT_AVAILABLE, HttpStatus.SERVICE_UNAVAILABLE);
			}
			throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE, "External error",
					"Error in Smartvista issuer host service");
		}
		return super.handle(e);
	}

}
