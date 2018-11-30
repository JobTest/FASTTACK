package com.cts.fasttack.mdes.server.converter;

import java.util.Date;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsNotifyTokenUpdatedDto;
import com.cts.fasttack.mdes.server.dict.TokenEventType;
import com.cts.fasttack.mdes.server.dto.NotifyTokenUpdatedRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class NotifyTokenUpdatedRequestDtoToJmsDtoConverter extends AbstractConverter<NotifyTokenUpdatedRequestDto, JmsNotifyTokenUpdatedDto> {

    @Autowired
    private TokenToJmsTokenDtoConverter tokenToJmsTokenDtoConverter;

    @Override
    protected JmsNotifyTokenUpdatedDto generateTarget() {
        return new JmsNotifyTokenUpdatedDto();
    }

    @Override
    protected void lightConvert(NotifyTokenUpdatedRequestDto source, JmsNotifyTokenUpdatedDto target) {
        target.setReasonCode(source.getReasonCode());
        target.setRequestId(source.getRequestId());
        target.setTokens(tokenToJmsTokenDtoConverter.convert(source.getTokens()));
        target.setTokenEventType(TokenEventType.TOKEN_STATUS_UPDATED.name());
        target.setTokenEventDate(new Date());
    }
}
