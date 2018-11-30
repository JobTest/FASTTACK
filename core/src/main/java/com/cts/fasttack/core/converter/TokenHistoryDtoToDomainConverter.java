package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.TokenHistory;
import com.cts.fasttack.core.dto.TokenHistoryDto;

/**
 * Convert {@link TokenHistoryDto} into {@link TokenHistory}
 *
 * @author a.lipavets
 */
@Component
public class TokenHistoryDtoToDomainConverter extends AbstractConverter<TokenHistoryDto, TokenHistory> {
    @Override
    protected TokenHistory generateTarget() {
        return new TokenHistory();
    }

    @Override
    protected void lightConvert(TokenHistoryDto source, TokenHistory target) {
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
        target.setTokenStatus(source.getTokenStatus());
        target.setTokenExpdate(source.getTokenExpdate());
        target.setReminderPeriod(source.getReminderPeriod());
    }
}
