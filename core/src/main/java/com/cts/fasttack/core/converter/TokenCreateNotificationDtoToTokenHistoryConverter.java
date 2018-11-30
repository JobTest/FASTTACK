package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenCreateNotificationDtoToTokenHistoryConverter extends AbstractConverter<JmsTokenCreateNotificationDto, TokenHistoryDto> {
    @Override
    protected TokenHistoryDto generateTarget() {
        return new TokenHistoryDto();
    }

    @Override
    protected void lightConvert(JmsTokenCreateNotificationDto source, TokenHistoryDto target) {
        target.setTokenRefId(source.getTokenReferenceID());
        target.setTokenRequestorId(source.getTokenRequestorID());
        target.setWprequestId(source.getPanReferenceID());
        target.setTokenEventSource(TokenEventSource.TR.name());
        target.setTokenEventDate(source.getDateTimeOfEvent());
        target.setTokenEventType(source.getEventType());
        target.setSuccess(true);
    }
}
