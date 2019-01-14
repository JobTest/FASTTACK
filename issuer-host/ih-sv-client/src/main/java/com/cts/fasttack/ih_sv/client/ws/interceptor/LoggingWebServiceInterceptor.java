package com.cts.fasttack.ih_sv.client.ws.interceptor;

import com.cts.fasttack.common.core.util.ObjectUtil;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.logging.dto.LoggingMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.server.endpoint.interceptor.SoapEnvelopeLoggingInterceptor;

import javax.xml.soap.MimeHeader;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author d.ishchenko
 */
public class LoggingWebServiceInterceptor extends SoapEnvelopeLoggingInterceptor implements ClientInterceptor {

	private Logger log;
	private String uri;

	public LoggingWebServiceInterceptor(String loggerName, String uri) {
		this.log = LogManager.getLogger(loggerName);
		this.uri = uri;
	}

	@Override
	public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
		if (log.isDebugEnabled() || log.isTraceEnabled()) {
			SaajSoapMessage message = (SaajSoapMessage) messageContext.getRequest();
			String id = getId(StringUtil.getElementsByTagName(getMessageSource(message.getPayloadSource()), "avs1:requestId"));
			messageContext.setProperty(LoggingMessage.ID_KEY, id);
			Iterator<MimeHeader> headers = ObjectUtil
					.uncheckedCast(message.getSaajMessage().getMimeHeaders().getAllHeaders());
			Iterable<MimeHeader> headersIterable = () -> headers;
			logPayload(message,
					new LoggingMessage(LoggingMessage.REQUEST_MESSAGE, id).remoteAddress(uri)
							.header(StreamSupport.stream(headersIterable.spliterator(), false)
									.map(mimeHeader -> mimeHeader.getName() + " = " + mimeHeader.getValue())
									.collect(Collectors.joining(",")))
							.address(message.getSoapAction()));
		}
		return true;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
		afterCompletion(messageContext);
		return true;
	}

	@Override
	public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
		afterCompletion(messageContext);
		return true;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {
	}

	private void afterCompletion(MessageContext messageContext) {
		if (log.isDebugEnabled() || log.isTraceEnabled()) {
			String id = (String) messageContext.getProperty(LoggingMessage.ID_KEY);
			if (StringUtils.isNotEmpty(id)) {
				SaajSoapMessage message = (SaajSoapMessage) messageContext.getResponse();
				Iterator<MimeHeader> headers = ObjectUtil
						.uncheckedCast(message.getSaajMessage().getMimeHeaders().getAllHeaders());
				Iterable<MimeHeader> headersIterable = () -> headers;
				logPayload(message,
						new LoggingMessage(LoggingMessage.RESPONSE_MESSAGE, id).message(message.getFaultReason())
								.header(StreamSupport.stream(headersIterable.spliterator(), false)
										.map(mimeHeader -> mimeHeader.getName() + " = " + mimeHeader.getValue())
										.collect(Collectors.joining(","))));
			}
		}
	}

	private void logPayload(SaajSoapMessage message, LoggingMessage loggingMessage) {
		String messageSource = getMessageSource(message.getPayloadSource());
		long start = System.currentTimeMillis();
		if (StringUtils.isNotEmpty(messageSource)) {
			if (log.isDebugEnabled()) {
				log.debug(loggingMessage.resetPayload(StringUtil.sensitiveFieldsFromXmlHiding(messageSource)));
			}
			if (log.isTraceEnabled()) {
				if (!messageSource.contains("password")) log.trace(loggingMessage.resetPayload(messageSource));
			}
		}
		long end = System.currentTimeMillis();
		log.trace("Log payload took - " + (end - start) + "ms");
	}

	private String getMessageSource(Source source) {
		if (source != null) {
			long start = System.currentTimeMillis();
			try {
				Transformer transformer = createTransformer();
				transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
				transformer.setOutputProperty(OutputKeys.INDENT, "no");
				StringWriter writer = new StringWriter();
				transformer.transform(source, new StreamResult(writer));
				return writer.toString();
			} catch (TransformerException e) {
				log.warn("Couldn't transform source to xml string", e);
			} finally {
				long end = System.currentTimeMillis();
				log.trace("Get message source took - " + (end - start) + "ms");
			}
		}
		return null;
	}

	private String getId(String id) {
		return id!=null ? id : UUID.randomUUID().toString();
	}
}
