package com.cts.fasttack.bank.server.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.server.dto.TokenInfoRequestDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenInfoMessageDto;

/**
 * {@link TokenInfoRequestDto} to {@link JmsTokenInfoMessageDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class TokenInfoRequestDtoToJmsTokenInfoMessageDtoConverter extends AbstractConverter<TokenInfoRequestDto, JmsTokenInfoMessageDto> {

    @Override
    protected JmsTokenInfoMessageDto generateTarget() {
        return new JmsTokenInfoMessageDto();
    }

    @Override
    protected void lightConvert(TokenInfoRequestDto source, JmsTokenInfoMessageDto target) {
        target.setRequestId(source.getRequestId());
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setPan(source.getPan());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        target.setIps(source.getIps());
        target.setUserId(source.getAuditInfo().getUserId());
        target.setUserName(source.getAuditInfo().getUserName());
    }
}
