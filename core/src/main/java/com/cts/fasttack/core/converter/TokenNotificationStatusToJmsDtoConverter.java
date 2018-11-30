package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.InternationalPaymentSystem;
import com.cts.fasttack.jms.dto.JmsTokenNotificationDto;
import com.cts.fasttack.jms.dto.JmsTokenStatusUpdatedDto;
import com.cts.fasttack.jms.dto.TokenNotificationJmsMessage;
import org.springframework.stereotype.Component;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenNotificationStatusToJmsDtoConverter extends AbstractConverter<TokenNotificationJmsMessage, JmsTokenStatusUpdatedDto> {
    @Override
    protected JmsTokenStatusUpdatedDto generateTarget() {
        return new JmsTokenStatusUpdatedDto();
    }

    @Override
    protected void lightConvert(TokenNotificationJmsMessage request, JmsTokenStatusUpdatedDto target) {
        JmsTokenNotificationDto source = request.getJmsTokenNotificationDto();
        target.setRequestId(String.valueOf(source.getEventID()));
        target.setTokenRequestorId(source.getTokenRequestorID());
        target.setTokenRefId(source.getTokenReferenceID());
        target.setStatus(source.getEncryptedData().getTokenInfo().getTokenStatus().substring(0, 1));
        target.setTokenExpiryMonth(source.getEncryptedData().getTokenInfo().getTokenExpirationDate().getMonth());
        target.setTokenExpiryYear(source.getEncryptedData().getTokenInfo().getTokenExpirationDate().getYear().substring(2));
        target.setIps(InternationalPaymentSystem.V.name());
        target.setMessageReasonCode(source.getMessageReasonCode());
    }
}
