package com.cts.fasttack.visa.vtis.server.service;

import com.cts.fasttack.visa.vtis.server.dict.EventType;
import com.cts.fasttack.visa.vtis.server.dto.TokenCreateNotificationRequestDto;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationResponseHolder;

import org.springframework.http.ResponseEntity;

import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author d.ishchenko
 */
public interface VisaTokenCreateService {

    String TOKEN_CREATE_NOTIFICATION = "TOKEN_CREATE_NOTIFICATION";

    /**
     * Sends tokenCreateNotification message to the queue
     *
     * @param request
     * @param tokenRequestorID
     * @param tokenReferenceID
     * @param eventType
     * @param eventID
     * @throws ServiceException
     */
    public ResponseEntity<?> tokenCreateNotification(TokenCreateNotificationRequestDto request, String tokenRequestorID, String tokenReferenceID, EventType eventType, String eventID, TokenNotificationResponseHolder responseHolder) throws ServiceException;
}
