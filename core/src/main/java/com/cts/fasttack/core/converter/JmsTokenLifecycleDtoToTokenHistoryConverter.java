package com.cts.fasttack.core.converter;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleDto;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleIpsDto;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsTokenLifecycleDtoToTokenHistoryConverter {

    public TokenHistoryDto convert(JmsTokenLifecycleDto source, String requestID, JmsTokenLifecycleIpsDto jmsTokenActivateIpsDto, String code, TokenStatus tokenStatus, Date tokenExpdate) {
        TokenHistoryDto target = new TokenHistoryDto();
        target.setTokenRefId(source.getTokenReferenceID());
        target.setTokenRequestorId(source.getTokenRequestorID());
        target.setWprequestId(requestID);
        target.setTokenEventType("ACTIVATE".equals(source.getStatus()) ? "TOKEN_ACTIVATE" : "TOKEN_STATUS_UPDATED");
        target.setTokenEventSource(TokenEventSource.IS.name());
        target.setTokenEventReason(source.getTokenReason());
        target.setMessageReasonCode(!StringUtils.isBlank(source.getTokenStatusUpdateReason()) ? source.getTokenStatusUpdateReason() : !StringUtils.isBlank(jmsTokenActivateIpsDto.getVtsReasonCode()) ? jmsTokenActivateIpsDto.getVtsReasonCode() : jmsTokenActivateIpsDto.getMdesReasonCode());
        target.setTokenEventDate(new Date());
        target.setEventRef(source.getEventRef());
        target.setMdesReason(source.getMdesReason());
        target.setSuccess(!(StringUtils.isNotBlank(code) && code.equals("01")));
        target.setTokenStatus(tokenStatus);
        target.setTokenExpdate(tokenExpdate);

        return target;
    }
}
