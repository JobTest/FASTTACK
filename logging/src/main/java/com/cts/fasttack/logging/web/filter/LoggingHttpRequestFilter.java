package com.cts.fasttack.logging.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.logging.dto.LoggingMessage;
import com.cts.fasttack.logging.dto.MessageHistoryDto;
import com.cts.fasttack.logging.service.MessageHistoryService;

/**
 * Filter to log http requests
 *
 * @author n.bizin
 */
public class LoggingHttpRequestFilter extends OncePerRequestFilter {

    private final Logger logger;

    private final String originator;

    @Autowired
    private MessageHistoryService messageHistoryService;

    public LoggingHttpRequestFilter(String originator, String loggerName) {
        this.originator = originator;
        this.logger = LogManager.getLogger(loggerName);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        request = new ContentCachingRequestWrapper(request);
        response = new ContentCachingResponseWrapper(response);

        String requestId = UUID.randomUUID().toString();
        Map<String, String> headers = Collections.list(request.getHeaderNames()).stream().collect(Collectors.toMap(h -> h, request::getHeader));

        Date requestDate = new Date();

        // log the fact of receiving a REQUEST_MESSAGE
        if (logger.isDebugEnabled()) {
        	LoggingMessage requestMessage = new LoggingMessage(LoggingMessage.REQUEST_MESSAGE + System.lineSeparator() + "No request data available at this point (see below)", requestId)
                .header(headers)
                .address(request.getRequestURL().toString())
                .httpMethod(request.getMethod())
                .contentType(request.getContentType());
        	logger.debug(requestMessage);
        }
        if (logger.isTraceEnabled()) {
        	LoggingMessage requestMessage = new LoggingMessage(LoggingMessage.REQUEST_MESSAGE + System.lineSeparator() + "No request data available at this point (see below)", requestId)
                .header(headers)
                .address(request.getRequestURL().toString())
                .httpMethod(request.getMethod())
                .contentType(request.getContentType());
        	logger.trace(requestMessage);
        }

        filterChain.doFilter(request, response);

        String requestData = getRequestData(request);
        String responseData = getResponseData(response);

        // log REQUEST_MESSAGE with payload
        LoggingMessage requestMessage = new LoggingMessage(LoggingMessage.REQUEST_MESSAGE + System.lineSeparator() + "Message received at " + DateFormatUtils.format(requestDate, DateFormatEnum.DATETIME.getValue()), requestId)
                .header(headers)
                .address(request.getRequestURL().toString())
                .httpMethod(request.getMethod())
                .contentType(request.getContentType());
        log(requestMessage, request.getContentType(), requestData);

        // log RESPONSE_MESSAGE
        LoggingMessage responseMessage = new LoggingMessage(LoggingMessage.RESPONSE_MESSAGE, requestId)
                .header(headers)
                .responseCode(response.getStatus())
                .message(HttpStatus.valueOf(response.getStatus()).getReasonPhrase());
        log(responseMessage, response.getContentType(), responseData);

        // save message history if dispatcher servlet has exception
        Exception exception = (Exception) request.getAttribute(DispatcherServlet.EXCEPTION_ATTRIBUTE);
        if (exception != null) {
            LoggingMessage messageRawIn = new LoggingMessage(requestId)
                    .address(request.getRequestURL().toString())
                    .httpMethod(request.getMethod())
                    .contentType(request.getContentType())
                    .resetPayload(requestData);

            LoggingMessage messageRawOut = new LoggingMessage(requestId)
                    .responseCode(response.getStatus())
                    .message(HttpStatus.valueOf(response.getStatus()).getReasonPhrase())
                    .resetPayload(responseData != null ? responseData : exception.getMessage());

            MessageHistoryDto mh = new MessageHistoryDto();
            mh.setConnectorClient(originator);
            mh.setMsgDateIn(new Date());
            mh.setMsgDateOut(new Date());
            mh.setMsgRawIn(messageRawIn.toString());
            mh.setMsgRawOut(messageRawOut.toString());

            String messageType;
            int idx = request.getPathInfo().lastIndexOf("/");
            if (idx != -1) {
                messageType = request.getPathInfo().substring(idx + 1);
            } else {
                messageType = request.getPathInfo();
            }
            mh.setMsgType(StringUtils.substring(StringUtil.toUppercaseWordsWithUnderscores(messageType) + "_EXCEPTION", 0, 64));

            try {
                mh.setErrorCode((String) JsonUtil.fromJson(responseData, Map.class).get("errorCode"));
            } catch (Exception ex) {
                mh.setErrorCode("N/A");
            }

            messageHistoryService.save(mh);
        }
    }

    private void log(LoggingMessage loggingMessage, String contentType, String payload) {
        if (payload != null) {
            if (logger.isDebugEnabled()) {
            	String debugPayload = payload;
                if ("application/json".equals(contentType)) {
                	debugPayload = StringUtil.sensitiveFieldsHiding(payload);
                } else if ("application/xml".equals(contentType)) {
                	debugPayload = StringUtil.sensitiveFieldsFromXmlHiding(payload);
                }
                logger.debug(loggingMessage.resetPayload(debugPayload));
            }
            if (logger.isTraceEnabled()) {
                logger.trace(loggingMessage.resetPayload(payload));
            }
        }
    }

    private static String getRequestData(final HttpServletRequest request) throws UnsupportedEncodingException {
        String payload = null;
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
            }
        }
        return payload;
    }

    private static String getResponseData(final HttpServletResponse response) throws IOException {
        String payload = null;
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                wrapper.copyBodyToResponse();
            }
        }
        return payload;
    }
}
