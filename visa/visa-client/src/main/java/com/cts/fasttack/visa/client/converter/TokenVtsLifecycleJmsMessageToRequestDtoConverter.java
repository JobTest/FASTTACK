package com.cts.fasttack.visa.client.converter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleIpsDto;
import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;
import com.cts.fasttack.visa.client.dto.TokenLifecycleRequestDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenVtsLifecycleJmsMessageToRequestDtoConverter extends AbstractConverter<TokenLifecycleIpsJmsMessage, TokenLifecycleRequestDto> {

    @Autowired
    private JmsCardHolderInfoRequestToDtoConverter jmsCardHolderInfoRequestToDtoConverter;

    @Override
    protected TokenLifecycleRequestDto generateTarget() {
        return new TokenLifecycleRequestDto();
    }

    @Override
    protected void lightConvert(TokenLifecycleIpsJmsMessage request, TokenLifecycleRequestDto target) {
        JmsTokenLifecycleIpsDto source = request.getJmsTokenActivateIpsDto();
        target.setRequestID(String.valueOf(request.getMessageHistoryId()));
        target.setMessageReasonCode(source.getVtsReasonCode());
        target.setTokenReferenceID(source.getTokenRefID());
        target.setTokenRequestorID(source.getTokenRequestorID());
        target.setRequestReason(StringUtils.isNotBlank(source.getComment()) ? source.getComment() : source.getTokenReason());
        target.setActivationCode("3713".equals(source.getVtsReasonCode()) ? source.getActivationCode() : null);
        target.setOperationType(TokenEventStatus.DELETE.equals(TokenEventStatus.getInstance(source.getStatus())) ? source.getStatus() : "UPDATE");
        target.setCardholderInfo(jmsCardHolderInfoRequestToDtoConverter.convert(source.getCardHolderInfo()));
        target.setPanReferenceID(source.getPanReferenceId());
    }
}
