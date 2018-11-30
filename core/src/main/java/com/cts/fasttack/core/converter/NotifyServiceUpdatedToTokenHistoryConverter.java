package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dict.TokenEventSource;
import com.cts.fasttack.core.dto.TokenHistoryDto;
import com.cts.fasttack.jms.dto.JmsNotifyTokenUpdatedDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class NotifyServiceUpdatedToTokenHistoryConverter extends AbstractConverter<JmsNotifyTokenUpdatedDto, TokenHistoryDto> {
    @Override
    protected TokenHistoryDto generateTarget() {
        return new TokenHistoryDto();
    }

    @Override
    protected void lightConvert(JmsNotifyTokenUpdatedDto source, TokenHistoryDto target) {
        target.setTokenEventType(source.getTokenEventType());
        target.setTokenEventDate(source.getTokenEventDate());
        target.setWprequestId(source.getRequestId());
        target.setTokenEventSource(TokenEventSource.TR.name());

    }
}
