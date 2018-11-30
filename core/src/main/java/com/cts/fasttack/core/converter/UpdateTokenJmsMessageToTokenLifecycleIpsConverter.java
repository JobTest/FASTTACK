package com.cts.fasttack.core.converter;

import java.util.Map;

import org.springframework.stereotype.Component;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.jms.dto.JmsCardHolderInfoRequestDto;
import com.cts.fasttack.jms.dto.JmsTokenLifecycleIpsDto;
import com.cts.fasttack.jms.dto.JmsUpdateTokenDto;
import com.cts.fasttack.jms.dto.TokenLifecycleIpsJmsMessage;
import com.cts.fasttack.jms.dto.UpdateTokenJmsMessage;

/**
 * @author Dmitry Koval
 */
@Component
public class UpdateTokenJmsMessageToTokenLifecycleIpsConverter {

    public TokenLifecycleIpsJmsMessage convert(UpdateTokenJmsMessage request,
                                               Map<String, String> properties,
                                               TokenInfoDto tokenInfoDto,
                                               JmsCardHolderInfoRequestDto cardHolderInfoRequestDto,
                                               TokenStatus tokenStatus) {
        TokenLifecycleIpsJmsMessage tokenLifecycleIpsJmsMessage = new TokenLifecycleIpsJmsMessage();
        JmsUpdateTokenDto source = request.getUpdateTokenDto();
        JmsTokenLifecycleIpsDto target = new JmsTokenLifecycleIpsDto();

        target.setOrganization(properties.get(FEPropService.PROPERTY_ORG_NAME));
        target.setVtsReasonCode(String.valueOf(tokenStatus.getVtsReasonCode()));
        target.setUserId(source.getUserId());
        target.setUsername(source.getUsername());
        target.setComment(source.getComment());
        target.setTokenReason(source.getTokenReason());
        target.setCardHolderInfo(cardHolderInfoRequestDto);
        target.setStatus(source.getTokenEventStatus());
        target.setPanReferenceId(tokenInfoDto.getPanRefId());
        target.setStatus("UPDATE");

        return tokenLifecycleIpsJmsMessage.jmsTokenActivateIpsDto(target);
    }
}
