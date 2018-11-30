package com.cts.fasttack.core.converter;

import java.util.Map;

import org.springframework.stereotype.Component;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.core.service.FEPropService;
import com.cts.fasttack.jms.dto.JmsAuditInfoDto;
import com.cts.fasttack.jms.dto.JmsTokenUpdateMdesDto;
import com.cts.fasttack.jms.dto.JmsUpdateTokenDto;
import com.cts.fasttack.jms.dto.TokenUpdateMdesJmsMessage;
import com.cts.fasttack.jms.dto.UpdateTokenJmsMessage;

/**
 * @author Dmitry Koval
 */
@Component
public class UpdateTokenJmsMessageToTokenUpdateMdesConverter {

    public TokenUpdateMdesJmsMessage convert(UpdateTokenJmsMessage request, Map<String, String> properties, TokenInfoDto tokenInfoDto){
        JmsTokenUpdateMdesDto tokenUpdateMdesDto = new JmsTokenUpdateMdesDto();
        JmsUpdateTokenDto updateTokenDto = request.getUpdateTokenDto();
        tokenUpdateMdesDto.setNewAccountPan(updateTokenDto.getNewPan());
        tokenUpdateMdesDto.setExpirationDate(updateTokenDto.getNewExpDate());
        tokenUpdateMdesDto.setCommentText(updateTokenDto.getComment());
        tokenUpdateMdesDto.setReasonCode(updateTokenDto.getTokenReason());
        tokenUpdateMdesDto.setTokenUniqueReference(tokenInfoDto.getId().getTokenRefId());
        tokenUpdateMdesDto.setUpdateWalletProviderIndicator(updateTokenDto.getUpdateWalletProviderIndicator());

        JmsAuditInfoDto auditInfoDto = new JmsAuditInfoDto();
        auditInfoDto.setUserName(updateTokenDto.getUsername());
        auditInfoDto.setUserId(updateTokenDto.getUserId());
        auditInfoDto.setOrganization(properties.get(FEPropService.PROPERTY_ORG_NAME));
        auditInfoDto.setPhone(properties.get(FEPropService.PROPERTY_CALL_CENTER_AUTOMATED_NUMBER));
        tokenUpdateMdesDto.setAuditInfo(auditInfoDto);

        return new TokenUpdateMdesJmsMessage().jmsTokenUpdateMdesDto(tokenUpdateMdesDto);

    }
}
