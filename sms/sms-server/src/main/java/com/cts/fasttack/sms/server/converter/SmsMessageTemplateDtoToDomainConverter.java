package com.cts.fasttack.sms.server.converter;


import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.sms.server.data.SmsMessageTemplate;
import com.cts.fasttack.sms.server.dto.SmsMessageTemplateDto;

/**
 * @author Anton Leliuk
 */
@Component
public class SmsMessageTemplateDtoToDomainConverter extends AbstractConverter<SmsMessageTemplateDto, SmsMessageTemplate> {

    @Override
    protected SmsMessageTemplate generateTarget() {
        return new SmsMessageTemplate();
    }

    @Override
    protected void lightConvert(SmsMessageTemplateDto source, SmsMessageTemplate target) {
        target.setId(source.getId());
        target.setType(source.getType());
        target.setTemplate(source.getTemplate());
        target.setLastModified(source.getLastModified());
    }
}
