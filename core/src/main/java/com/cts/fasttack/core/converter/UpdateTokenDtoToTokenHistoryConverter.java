package com.cts.fasttack.core.converter;

import java.util.Date;

import org.springframework.stereotype.Component;
import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.core.dto.TokenInfoDto;

/**
 * @author Dmitry Koval
 */
@Component
public class UpdateTokenDtoToTokenHistoryConverter {

    public TokenHistoryDto convert(TokenInfoDto source, String requestID, String eventRef, String tokenEventReason) {
        TokenHistoryDto target = new TokenHistoryDto();
        target.setTokenRefId(source.getId().getTokenRefId());
        target.setTokenRequestorId(source.getId().getTokenRequestorId());
        target.setWprequestId(requestID);
        target.setTokenEventType("TOKEN_STATUS_UPDATED");
        target.setTokenEventSource(TokenEventSource.IS.name());
        target.setTokenEventReason(tokenEventReason);
        target.setTokenEventDate(new Date());
        target.setEventRef(eventRef);
        target.setSuccess(true);
        target.setTokenStatus(source.getTokenStatus());
        target.setTokenExpdate(source.getTokenExpdate());

        return target;
    }
}
