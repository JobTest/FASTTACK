package com.cts.fasttack.sms.client.rest;

import java.util.Map;

import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Dmitry Koval
 */
public interface SmsRestClient {

    /**
     * Request to Send SMS Message
     *
     * @param type               Type of Message
     * @param phone              Phone number
     * @param templateParameters Parameters for SMS Message Template
     * @throws ServiceException
     */
    void send(String type, String phone, Map<String, Object> templateParameters) throws ServiceException;
}
