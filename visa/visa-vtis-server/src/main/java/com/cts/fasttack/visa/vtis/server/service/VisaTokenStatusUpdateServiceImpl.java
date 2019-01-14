package com.cts.fasttack.visa.vtis.server.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.common.core.validation.ValidationSequence;
import com.cts.fasttack.jms.dto.JmsTokenNotificationDto;
import com.cts.fasttack.jms.dto.JmsVisaEncryptedDataDto;
import com.cts.fasttack.jms.dto.TokenNotificationJmsMessage;
import com.cts.fasttack.jms.dto.TokenNotificationJmsResponse;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.interceptor.ChangeLoggable;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.visa.common.dict.VisaErrorReasonCode;
import com.cts.fasttack.visa.common.dto.ErrorDetailsDto;
import com.cts.fasttack.visa.common.dto.ErrorResponseDto;
import com.cts.fasttack.visa.vtis.server.converter.TokenNotificationDtoToJmsDtoConverter;
import com.cts.fasttack.visa.vtis.server.dict.EventType;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationRequestDto;
import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationResponseHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Dmitry Koval
 * @author d.ishchenko
 */
@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VisaTokenStatusUpdateServiceImpl implements VisaTokenStatusUpdateService {

    @Autowired
    private CallingContext callingContext;

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private Validator validator;

    @Autowired
    private TokenNotificationDtoToJmsDtoConverter tokenNotificationDtoToJmsDtoConverter;

    @ChangeLoggable(itemType = VisaTokenStatusUpdateService.TOKEN_STATUS_UPDATE_NOTIFICATION, itemId = "#eventID", fields = {"#tokenRequestorID", "#tokenReferenceID", "#eventType"})
    @MessageHistoryOperation(connectorClient = "VTS", rawIn = "#request",
            tokenId = "#tokenReferenceID",
            maskedPan = "#responseHolder != null && #responseHolder.response != null ? #responseHolder.response.maskedPan : null",
            panSource = "#responseHolder != null && #responseHolder.response != null ? #responseHolder.response.panSource : null",
            panInternalId = "#responseHolder != null && #responseHolder.response != null ? #responseHolder.response.panInternalId : null",
            panInternalGuid = "#responseHolder != null && #responseHolder.response != null ? #responseHolder.response.panInternalGuid : null")
    public ResponseEntity<?> tokenStatusUpdateNotification(TokenNotificationRequestDto request, String tokenRequestorID, String tokenReferenceID, EventType eventType, String eventID, TokenNotificationResponseHolder responseHolder) throws ServiceException {
    	ErrorResponseDto errorResponse = null;
    	JmsTokenNotificationDto jmsTokenNotificationDto = null;

    	Set<ConstraintViolation<Object>> violations = validator.validate(request, ValidationSequence.class);

    	if (violations.isEmpty()) {
    		jmsTokenNotificationDto = tokenNotificationDtoToJmsDtoConverter.convert(request, tokenReferenceID, tokenRequestorID, eventType, eventID);
            violations = validateEncryptedData(jmsTokenNotificationDto.getEncryptedData());
    	}

    	if (!violations.isEmpty()) {
            errorResponse = new ErrorResponseDto(
                            VisaErrorReasonCode.invalidRequest,
                            violations.stream().map(item -> new ErrorDetailsDto(item.getPropertyPath().toString(), item.getMessage())).collect(Collectors.toList()));
        }

    	if (errorResponse == null) {
        	if (DateFormatUtil.stringToDate(DateFormatEnum.VTS_DATETIMEOFEVENT_FORMAT, request.getDateTimeOfEvent()) == null) {
        		List<ErrorDetailsDto> details = new ArrayList<ErrorDetailsDto>();
        		
        		details.add(new ErrorDetailsDto("dateTimeOfEvent", VisaErrorCode.Names.INVALID_FIELD_TYPE));
        		
        		errorResponse = new ErrorResponseDto(VisaErrorReasonCode.invalidRequest, details);
        	}
        }

    	if (errorResponse == null) {
            responseHolder.setResponse(integrationBus.inOut(() -> callingContext.getOriginator(), "tokenNotification",
                    new TokenNotificationJmsMessage()
                            .jmsTokenNotificationDto(jmsTokenNotificationDto)
                            .originator(callingContext.getOriginator()), TokenNotificationJmsResponse.class));
    	}

    	return errorResponse == null ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private Set<ConstraintViolation<Object>> validateEncryptedData(JmsVisaEncryptedDataDto encryptedData) {
    	Set<ConstraintViolation<Object>> result = null;

    	if (encryptedData.getCardholderInfo() != null) {
    		result = validator.validate(encryptedData.getCardholderInfo(), ValidationSequence.class);
    	}
    	if (encryptedData.getTokenInfo() != null) {
    		result = validator.validate(encryptedData.getTokenInfo(), ValidationSequence.class);
    	}
    	if (result == null) {
    		result = new HashSet<ConstraintViolation<Object>>();
    	}
    	
    	return result;
    }

}
