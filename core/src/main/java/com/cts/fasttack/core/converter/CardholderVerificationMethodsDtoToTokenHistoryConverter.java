package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.jms.dto.JmsCardholderVerificationMethodsDto;

/**
 * @author a.lipavets
 */
@Component
public class CardholderVerificationMethodsDtoToTokenHistoryConverter extends AbstractConverter<JmsCardholderVerificationMethodsDto, TokenHistoryDto> {
    @Override
    protected TokenHistoryDto generateTarget() {
        return new TokenHistoryDto();
    }

    @Override
    protected void lightConvert(JmsCardholderVerificationMethodsDto source, TokenHistoryDto target) {
        target.setTokenRefId(source.getTokenReferenceID());
        target.setTokenRequestorId(source.getTokenRequestorID());
        target.setWprequestId(source.getWpRequestId());
        target.setWpconversationId(source.getWpConversationId());
        target.setSuccess(true);
    }
}
