package com.cts.fasttack.common.core.rest.jwt.interceptor;

import com.cts.fasttack.common.core.rest.jwt.config.JwtParameters;
import com.cts.fasttack.common.core.rest.jwt.service.JwtService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Server interceptor which verify JWT signature
 * @author Anton Leliuk
 */
public class JwtServerHttpInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LogManager.getLogger(JwtServerHttpInterceptor.class);

    private JwtService jwtService;

    public JwtServerHttpInterceptor(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String signature = request.getHeader(JwtParameters.JWT_HEADER);
        boolean verify = false;
        if(StringUtils.isNotBlank(signature)){
            verify = jwtService.verify(signature);
            if(!verify){
                log.warn("The JWT signature is not correct for request - " + request.getRequestURI());
            }
        } else {
            log.warn("The JWT header is missing for request - " + request.getRequestURI());
        }
        if(!verify){
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
        return verify;
    }
}
