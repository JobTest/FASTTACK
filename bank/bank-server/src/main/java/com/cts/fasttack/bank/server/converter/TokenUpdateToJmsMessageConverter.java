package com.cts.fasttack.bank.server.converter;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.server.dto.TokenUpdateRequestDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsUpdateTokenDto;

/**
 * @author a.lipavets
 */
@Component
public class TokenUpdateToJmsMessageConverter extends AbstractConverter<TokenUpdateRequestDto, JmsUpdateTokenDto> {
    @Override
    protected JmsUpdateTokenDto generateTarget() {
        return new JmsUpdateTokenDto();
    }

    @Override
    protected void lightConvert(TokenUpdateRequestDto source, JmsUpdateTokenDto jmsUpdateTokenDto) {
        jmsUpdateTokenDto.setUsername(source.getAuditInfo().getUserName());
        jmsUpdateTokenDto.setUserId(source.getAuditInfo().getUserId());
        jmsUpdateTokenDto.setTokenRequestorId(source.getTokenRequestorId());
        jmsUpdateTokenDto.setComment(source.getCommentText());
        jmsUpdateTokenDto.setTokenRefId(source.getTokenRefId());
        jmsUpdateTokenDto.setTokenReason(source.getReasonCode());
        jmsUpdateTokenDto.setOldPan(source.getOldAccountPan());
        jmsUpdateTokenDto.setNewPan(source.getNewAccountPan());
        jmsUpdateTokenDto.setOldExpDate(StringUtils.isNotBlank(source.getOldExpiryMonth()) && StringUtils.isNotBlank(source.getOldExpiryYear()) ? source.getOldExpiryMonth().concat(source.getOldExpiryYear()) : null);
        jmsUpdateTokenDto.setNewExpDate(StringUtils.isNotBlank(source.getNewExpiryMonth()) && StringUtils.isNotBlank(source.getNewExpiryYear()) ? source.getNewExpiryMonth().concat(source.getNewExpiryYear()) : null);
        jmsUpdateTokenDto.setPanInternalGuid(source.getPanInternalGUID());
        jmsUpdateTokenDto.setPanInternalId(source.getPanInternalId());
        jmsUpdateTokenDto.setNewPanInternalId(source.getNewPanInternalId());
        jmsUpdateTokenDto.setNewPanInternalGuid(source.getNewPanInternalGUID());
        jmsUpdateTokenDto.setUpdateWalletProviderIndicator(source.getUpdateWalletProviderIndicator());
    }
}
