package com.cts.fasttack.visa.vtis.server.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.logging.interceptor.ChangeLoggable;
import com.cts.fasttack.visa.vtis.server.dict.EventType;
import com.cts.fasttack.visa.vtis.server.dto.TokenCreateNotificationRequestDto;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationRequestDto;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationResponseHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Dmitry Koval
 */
@Service
public class VisaServiceImpl implements VisaService {

    @Autowired
    private VisaTokenCreateService visaTokenCreateService;

    @Autowired
    private VisaTokenStatusUpdateService visaTokenStatusUpdateService;

    @ChangeLoggable(itemType = VisaService.TOKEN_NOTIFICATION, itemId = "#eventID", fields = {"#tokenRequestorID", "#tokenReferenceID", "#eventType"})
    public ResponseEntity<?> tokenNotification(HttpEntity<String> requestDto, String tokenRequestorID, String tokenReferenceID, String eventTypeStr, String eventID) throws ServiceException {
    	validate(tokenRequestorID, tokenReferenceID, eventTypeStr, eventID);

    	EventType eventType = EventType.valueOf(eventTypeStr);
    	if (eventType.isTokenCreated()) {
            TokenCreateNotificationRequestDto tokenCreateNotificationRequestDto;
            try {
            	tokenCreateNotificationRequestDto = JsonUtil.fromJson(requestDto.getBody(), TokenCreateNotificationRequestDto.class);
            } catch (Exception ex) {
            	throw new ServiceException(StandardErrorCodes.INVALID_JSON);
            }

            return visaTokenCreateService.tokenCreateNotification(tokenCreateNotificationRequestDto,  tokenRequestorID, tokenReferenceID, eventType, eventID, new TokenNotificationResponseHolder());
        } else if (eventType.isTokenStatusUpdated()) {
            TokenNotificationRequestDto tokenNotificationRequestDto;
            try {
            	tokenNotificationRequestDto = JsonUtil.fromJson(requestDto.getBody(), TokenNotificationRequestDto.class);
            } catch (Exception ex) {
            	throw new ServiceException(StandardErrorCodes.INVALID_JSON);
            }

            return visaTokenStatusUpdateService.tokenStatusUpdateNotification(tokenNotificationRequestDto, tokenRequestorID, tokenReferenceID, eventType, eventID, new TokenNotificationResponseHolder());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void validate(String tokenRequestorID, String tokenReferenceID, String eventType, String eventID) throws ServiceException {
        if (tokenRequestorID == null) {
        	throw new ServiceException(StandardErrorCodes.MISSING_REQUIRED_FIELD, "tokenRequestorID");
        }
        try {
        	Long.valueOf(tokenRequestorID);
        } catch (Exception ex) {
        	throw new ServiceException(StandardErrorCodes.INVALID_FIELD_VALUE, "tokenRequestorID");
        }
        if (tokenRequestorID.length() > 11) {
        	throw new ServiceException(StandardErrorCodes.INVALID_FIELD_LENGTH, "tokenRequestorID");
        }
    	
        if (tokenReferenceID == null) {
        	throw new ServiceException(StandardErrorCodes.MISSING_REQUIRED_FIELD, "tokenReferenceID");
        }
        if (tokenReferenceID.length() > 32) {
        	throw new ServiceException(StandardErrorCodes.INVALID_FIELD_LENGTH, "tokenReferenceID");
        }

        if (eventType == null) {
        	throw new ServiceException(StandardErrorCodes.MISSING_REQUIRED_FIELD, "eventType");
        }
        try {
            EventType.valueOf(eventType);
        } catch (Exception ex) {
        	throw new ServiceException(StandardErrorCodes.INVALID_FIELD_VALUE, "eventType");
        }

        if (eventID == null) {
        	throw new ServiceException(StandardErrorCodes.MISSING_REQUIRED_FIELD, "eventID");
        }
        if (eventID.length() > 32) {
        	throw new ServiceException(StandardErrorCodes.INVALID_FIELD_VALUE, "eventID");
        }
    }

}
