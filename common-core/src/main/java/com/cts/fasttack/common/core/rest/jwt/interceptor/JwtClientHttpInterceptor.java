package com.cts.fasttack.common.core.rest.jwt.interceptor;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.jwt.config.JwtParameters;
import com.cts.fasttack.common.core.rest.jwt.service.JwtService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Client interceptor which add JWT to the header of each request
 * @author Anton Leliuk
 */
public class JwtClientHttpInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger log = LogManager.getLogger(JwtClientHttpInterceptor.class);

    private String originator;

    private long ttl;

    private JwtService jwtService;

    public JwtClientHttpInterceptor(JwtService jwtService, String originator, long ttl) {
        this.originator = originator;
        this.ttl = ttl;
        this.jwtService = jwtService;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        try {
            request.getHeaders().add(JwtParameters.JWT_HEADER, jwtService.sign(originator, ttl));
        } catch (ServiceException e) {
            log.warn("Couldn't generate JWT signature", e);
        }
        return execution.execute(request, body);
    }
}
