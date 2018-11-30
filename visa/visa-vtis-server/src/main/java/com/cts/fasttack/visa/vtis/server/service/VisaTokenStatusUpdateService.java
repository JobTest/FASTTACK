package com.cts.fasttack.visa.vtis.server.service;

import com.cts.fasttack.visa.vtis.server.dict.EventType;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationRequestDto;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationResponseHolder;

import org.springframework.http.ResponseEntity;
import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author d.ishchenko
 */
public interface VisaTokenStatusUpdateService {

    String TOKEN_STATUS_UPDATE_NOTIFICATION = "TOKEN_STATUS_UPDATE_NOTIFICATION";

    /**
     * Sends tokenStatusUpdateNotification message to the queue
     *
     * @param request
     * @param tokenRequestorID
     * @param tokenReferenceID
     * @param eventType
     * @param eventID
     * @throws ServiceException
     */
    public ResponseEntity<?> tokenStatusUpdateNotification(TokenNotificationRequestDto request, String tokenRequestorID, String tokenReferenceID, EventType eventType, String eventID, TokenNotificationResponseHolder responseHolder) throws ServiceException;
}
