package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.jms.dto.JmsTokenNotificationDto;
import com.cts.fasttack.jms.dto.TokenNotificationJmsMessage;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenNotificationDtoToTokenHistoryConverter extends AbstractConverter<TokenNotificationJmsMessage, TokenHistoryDto> {

    @Override
    protected TokenHistoryDto generateTarget() {
        return new TokenHistoryDto();
    }

    @Override
    protected void lightConvert(TokenNotificationJmsMessage request, TokenHistoryDto target) {
        JmsTokenNotificationDto source = request.getJmsTokenNotificationDto();
        target.setTokenRefId(source.getTokenReferenceID());
        target.setTokenRequestorId(source.getTokenRequestorID());
        target.setWprequestId(String.valueOf(request.getMessageHistoryId()));
        target.setTokenEventSource(TokenEventSource.TR.name());
        target.setTokenEventDate(source.getDateTimeOfEvent());
        target.setTokenEventType(source.getEventType());
        target.setSuccess(true);
    }
}
