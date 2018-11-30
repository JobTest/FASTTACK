package com.cts.fasttack.core.converter;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dict.TokenStatus;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.jms.dto.JmsNotifyServiceDto;

/**
 * @author d.ishchenko
 */
@Component
public class NotifyServiceDtoToTokenHistoryConverter {

	public TokenHistoryDto convert(JmsNotifyServiceDto source, Date tokenExpdate) {
		TokenHistoryDto target = new TokenHistoryDto();
        target.setTokenRefId(source.getTokenUniqueReference());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setWprequestId(source.getRequestId());
        target.setWpconversationId(source.getCorrelationId());
        target.setTokenEventSource(TokenEventSource.TR.name());
        target.setTokenEventDate(source.getTokenEventDate());
        target.setTokenEventType(source.getTokenEventType());
        target.setSuccess(true);
        target.setTokenStatus(TokenStatus.A);
        target.setTokenExpdate(tokenExpdate);
        
        return target;
    }
}
