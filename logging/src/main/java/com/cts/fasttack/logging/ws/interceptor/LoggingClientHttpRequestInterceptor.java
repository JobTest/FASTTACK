package com.cts.fasttack.logging.ws.interceptor;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import com.cts.fasttack.common.core.util.StringUtil;
import com.cts.fasttack.logging.dto.LoggingMessage;

/**
 * Rest interceptor which will log request and response messages
 *
 * @author Anton Leliuk
 */
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private final Logger log;

    public LoggingClientHttpRequestInterceptor(String loggerName) {
        this.log = LogManager.getLogger(loggerName);
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        return logExecute(request, body, execution, UUID.randomUUID().toString());
    }

    private ClientHttpResponse logExecute(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, String requestId) throws IOException {
        if (log.isDebugEnabled() || log.isTraceEnabled()) {
            LoggingMessage loggingMessage = new LoggingMessage(LoggingMessage.REQUEST_MESSAGE, requestId)
                    .header(request.getHeaders())
                    //NPE here for GET requests
//                    .contentType(request.getHeaders().getContentType().toString())
                    .address(request.getURI().toString())
                    .httpMethod(request.getMethod().name());


            MediaType mediaType = Optional.ofNullable(request.getHeaders().getContentType()).orElse(MediaType.APPLICATION_JSON_UTF8);
            loggingMessage.contentType(mediaType.toString());

            String originalPayload = new String(body);
            if (log.isDebugEnabled()) {
                if(mediaType.isCompatibleWith(MediaType.APPLICATION_XML)){
                    log.debug(loggingMessage.resetPayload(StringUtil.sensitiveFieldsFromXmlHiding(originalPayload)));
                } else {
                    log.debug(loggingMessage.resetPayload(StringUtil.sensitiveFieldsHiding(originalPayload)));
                }
            }
            if (log.isTraceEnabled()) {
                if (!originalPayload.contains("password")) log.trace(loggingMessage.resetPayload(originalPayload));
            }
        }

        ClientHttpResponse response = null;
        try {
            response = execution.execute(request, body);
            return response;
        } finally {
            if (response != null) {
                if (log.isDebugEnabled() || log.isTraceEnabled()) {
                    /*
                     * Calling {@code response.getRawStatusCode()} we avoid {@code IOException} if we call first response.getBody
                     */
                    response.getRawStatusCode();
                    String originalPayload = "";
                    try {
                        if (response.getBody() != null) {
                            StringWriter sw = new StringWriter();
                            IOUtils.copy(response.getBody(), sw, StandardCharsets.UTF_8);
                            originalPayload = sw.toString();
                        }
                    } catch (IOException ioe) {
                        log.warn("Cannot access HTTP response body for details: " + ioe.getMessage());
                    }

                    MediaType mediaType = Optional.ofNullable(response.getHeaders().getContentType()).orElse(MediaType.APPLICATION_JSON_UTF8);
                    LoggingMessage message = new LoggingMessage(LoggingMessage.RESPONSE_MESSAGE, requestId)
                            .responseCode(response.getRawStatusCode())
                            .header(response.getHeaders())
                            .message(response.getStatusText());
                    if (log.isDebugEnabled()) {
                        if(mediaType.isCompatibleWith(MediaType.APPLICATION_XML) || mediaType.isCompatibleWith(MediaType.TEXT_XML)){
                            log.debug(message.resetPayload(StringUtil.sensitiveFieldsFromXmlHiding(originalPayload)));
                        } else {
                            log.debug(message.resetPayload(StringUtil.sensitiveFieldsHiding(originalPayload)));
                        }
                    }
                    if (log.isTraceEnabled()) {
                        if (!originalPayload.contains("password")) log.trace(message.resetPayload(originalPayload));
                    }
                }
            }
        }
    }
}
