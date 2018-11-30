package com.cts.fasttack.sms.server.converter;


import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.sms.server.data.SmsMessageTemplate;
import com.cts.fasttack.sms.server.dto.SmsMessageTemplateDto;

/**
 * @author Anton Leliuk
 */
@Component
public class SmsMessageTemplateToDtoConverter extends IdentifierToDtoConverter<Long, SmsMessageTemplate, SmsMessageTemplateDto> {

    @Override
    protected SmsMessageTemplateDto generateTarget() {
        return new SmsMessageTemplateDto();
    }

    @Override
    protected void lightConvert(SmsMessageTemplate source, SmsMessageTemplateDto target) {
        super.lightConvert(source, target);
        target.setType(source.getType());
        target.setTemplate(source.getTemplate());
        target.setLastModified(source.getLastModified());
    }
}
