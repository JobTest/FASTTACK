package com.cts.fasttack.core.converter;

import java.util.Map;

import org.springframework.stereotype.Component;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleDto;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleIpsDto;
import com.cts.fasttack.jms.dto.TokenLifecycleJmsMessage;
import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenLifecycleJmsMessageToIpsConverter {

    public TokenLifecycleIpsJmsMessage convert(TokenLifecycleJmsMessage request, Map<String, String> properties) {
        TokenLifecycleIpsJmsMessage tokenLifecycleIpsJmsMessage = new TokenLifecycleIpsJmsMessage();
        JmsTokenLifecycleDto source = request.getJmsTokenLifecycleDto();
        JmsTokenLifecycleIpsDto target = new JmsTokenLifecycleIpsDto();

        target.setOrganization(properties.get(FEPropService.PROPERTY_ORG_NAME));
        target.setMdesReasonCode(source.getMdesReason());
        target.setVtsReasonCode(String.valueOf(TokenStatus.valueOfFirstWord(source.getStatus()).getVtsReasonCode()));
        target.setUserId(source.getUserId());
        target.setUsername(source.getUsername());
        target.setTokenRefID(source.getTokenReferenceID());
        target.setTokenRequestorID(source.getTokenRequestorID());
        target.setComment(source.getComment());
        target.setStatus(source.getStatus());
        target.setReasonSuspend(source.getReasonSuspend());
        target.setTokenReason(source.getTokenReason());
        target.setActivationCode("000000");
        target.setPan(source.getPan());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());

        return tokenLifecycleIpsJmsMessage.jmsTokenActivateIpsDto(target);
    }
}
