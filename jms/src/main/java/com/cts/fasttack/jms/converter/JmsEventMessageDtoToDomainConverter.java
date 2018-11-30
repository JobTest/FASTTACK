package com.cts.fasttack.jms.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.data.JmsEventMessage;
import com.cts.fasttack.jms.dto.JmsEventMessageDto;

@Component
public class JmsEventMessageDtoToDomainConverter extends AbstractConverter<JmsEventMessageDto, JmsEventMessage> {

    @Override
    protected JmsEventMessage generateTarget() {
        return new JmsEventMessage();
    }

    @Override
    protected void lightConvert(JmsEventMessageDto source, JmsEventMessage target) {
        target.setId(source.getId());
        target.setContent(source.getContent());
        target.setMessageId(source.getMessageId());
        target.setProcessorName(source.getProcessorName());
        target.setNumberOfDeliveryAttempts(source.getNumberOfDeliveryAttempts());
        target.setMessageHistoryId(source.getMessageHistoryId());
    }
}
