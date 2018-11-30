package com.cts.fasttack.sms.server.converter;


import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.sms.server.data.SmsMessage;
import com.cts.fasttack.sms.server.dto.SmsMessageDto;

/**
 * @author Anton Leliuk
 */
@Component
public class SmsMessageDtoToDomainConverter extends AbstractConverter<SmsMessageDto, SmsMessage> {

    @Override
    protected SmsMessage generateTarget() {
        return new SmsMessage();
    }

    @Override
    protected void lightConvert(SmsMessageDto source, SmsMessage target) {
        target.setMessageId(source.getMessageId());
        target.setType(source.getType());
        target.setPhone(source.getPhone());
        target.setText(source.getText());
        target.setStatus(source.getStatus());
        target.setDescription(source.getDescription());
        target.setDateCreate(source.getDateCreate());
        target.setDateSend(source.getDateSend());
    }
}
