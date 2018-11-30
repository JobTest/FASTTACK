package com.cts.fasttack.visa.vtis.server.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Dmitry Koval
 */
public interface VisaService {

    String TOKEN_NOTIFICATION = "TOKEN_NOTIFICATION";

    /**
     * Sent message in queue from condition of the eventType
     *
     * @param requestDto
     * @param tokenRequestorID
     * @param tokenReferenceID
     * @param eventType
     * @param eventID
     * @throws ServiceException
     */
    public ResponseEntity<?> tokenNotification(HttpEntity<String> requestDto, String tokenRequestorID, String tokenReferenceID, String eventType, String eventID) throws ServiceException;
}
