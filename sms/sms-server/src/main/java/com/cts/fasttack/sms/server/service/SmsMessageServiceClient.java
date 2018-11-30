package com.cts.fasttack.sms.server.service;


import java.util.Map;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.sms.server.listener.SmsMessageSenderListener;

/**
 * Service for sending SMS messages
 *
 * @author Anton Leliuk
 */
public interface SmsMessageServiceClient {

    /**
     * Send SMS message
     *
     * @param type
     * @param phone
     * @param parametersTemplate
     * @throws ServiceException
     */
    void send(String type, String phone, Map<String, Object> parametersTemplate) throws ServiceException;

    /**
     * Send SMS message and notify listeners
     *
     * @param type
     * @param phone
     * @param parametersTemplate
     * @param listener
     * @throws ServiceException
     */
    void send(String type, String phone, Map<String, Object> parametersTemplate, SmsMessageSenderListener listener) throws ServiceException;
}
