package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardTokenizedResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenCreateNotificationResponseDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class CardTokenizedResponseToTokenCreateNotificationResponseConverter extends AbstractConverter<JmsCardTokenizedResponseDto, JmsTokenCreateNotificationResponseDto> {
    @Override
    protected JmsTokenCreateNotificationResponseDto generateTarget() {
        return new JmsTokenCreateNotificationResponseDto();
    }

    @Override
    protected void lightConvert(JmsCardTokenizedResponseDto source, JmsTokenCreateNotificationResponseDto target) {
        target.setCustomerId(source.getCustomerId());
        target.setConversationId(source.getConversationId());
        target.setCode(source.getCode());
        target.setCustomerPhone(source.getCustomerPhone());
        target.setErrorMessage(source.getErrorMessage());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setPanInternalId(source.getPanInternalId());
        target.setRequestId(source.getRequestId());
    }
}
