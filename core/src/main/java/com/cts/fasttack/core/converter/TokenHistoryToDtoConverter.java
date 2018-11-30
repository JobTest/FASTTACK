package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.core.data.TokenHistory;
import com.cts.fasttack.core.dto.TokenHistoryDto;

/**
 * Convert {@link TokenHistory} into {@link TokenHistoryDto}
 *
 * @author a.lipavets
 */
@Component
public class TokenHistoryToDtoConverter extends IdentifierToDtoConverter<Long, TokenHistory, TokenHistoryDto> {
    @Override
    protected TokenHistoryDto generateTarget() {
        return new TokenHistoryDto();
    }

    @Override
    public void convert(TokenHistory source, TokenHistoryDto target) {
        target.setId(source.getId());
        target.setEventRef(source.getEventRef());
        target.setMessageReasonCode(source.getMessageReasonCode());
        target.setTokenEventDate(source.getTokenEventDate());
        target.setTokenEventReason(source.getTokenEventReason());
        target.setTokenEventSource(source.getTokenEventSource());
        target.setTokenEventType(source.getTokenEventType());
        target.setTokenRefId(source.getTokenRefId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setWpconversationId(source.getWpconversationId());
        target.setWprequestId(source.getWprequestId());
        target.setMdesReason(source.getMdesReason());
        target.setSuccess(source.getSuccess());
    }
}
