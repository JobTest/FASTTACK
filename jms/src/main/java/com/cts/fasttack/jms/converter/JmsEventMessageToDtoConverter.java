package com.cts.fasttack.jms.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.jms.data.JmsEventMessage;
import com.cts.fasttack.jms.dto.JmsEventMessageDto;

@Component
public class JmsEventMessageToDtoConverter extends IdentifierToDtoConverter<Long, JmsEventMessage, JmsEventMessageDto> {

    protected JmsEventMessageDto generateTarget() {
        return new JmsEventMessageDto();
    }

    @Override
    public void convert(JmsEventMessage source, JmsEventMessageDto target) {
        target.setId(source.getId());
        target.setContent(source.getContent());
        target.setMessageId(source.getMessageId());
        target.setProcessorName(source.getProcessorName());
        target.setNumberOfDeliveryAttempts(source.getNumberOfDeliveryAttempts());
        target.setMessageHistoryId(source.getMessageHistoryId());
    }
}
