package com.cts.fasttack.logging.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.cts.fasttack.common.core.data.ProcessingArea;
import com.cts.fasttack.logging.service.CallingContext;

/**
 * Интерсептор, устанавливающий данные о вызывающем приложении в {@link CallingContext}
 */
public class CallingContextInterceptor extends HandlerInterceptorAdapter {

    private String originator;

    private ProcessingArea processingArea;

    private CallingContext callingContext;

    public CallingContextInterceptor(String originator, ProcessingArea processingArea, CallingContext callingContext) {
        this.originator = originator;
        this.processingArea = processingArea;
        this.callingContext = callingContext;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        callingContext.setContext(originator);
        callingContext.setProcessingArea(processingArea);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        callingContext.clean();
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public void setProcessingArea(ProcessingArea processingArea) {
        this.processingArea = processingArea;
    }
}
