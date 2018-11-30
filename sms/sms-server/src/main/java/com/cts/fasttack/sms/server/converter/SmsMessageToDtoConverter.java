package com.cts.fasttack.sms.server.converter;


import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.sms.server.data.SmsMessage;
import com.cts.fasttack.sms.server.dto.SmsMessageDto;

/**
 * @author Anton Leliuk
 */
@Component
public class SmsMessageToDtoConverter extends IdentifierToDtoConverter<Long, SmsMessage, SmsMessageDto> {

    @Override
    protected SmsMessageDto generateTarget() {
        return new SmsMessageDto();
    }

    @Override
    protected void lightConvert(SmsMessage source, SmsMessageDto target) {
        target.setMessageId(source.getMessageId());
        target.setType(source.getType());
        target.setPhone(source.getPhone());
        target.setStatus(source.getStatus());
        target.setText(source.getText());
        target.setDescription(source.getDescription());
        target.setDateSend(source.getDateSend());
        target.setDateCreate(source.getDateCreate());
    }
}
