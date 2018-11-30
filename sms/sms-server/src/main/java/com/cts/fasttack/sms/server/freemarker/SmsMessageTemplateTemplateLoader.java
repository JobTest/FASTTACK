package com.cts.fasttack.sms.server.freemarker;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.sms.server.dto.SmsMessageTemplateDto;
import com.cts.fasttack.sms.server.service.SmsMessageTemplateService;

import freemarker.cache.TemplateLoader;

/**
 * Loader which loads templates from DB
 * @author Anton Leliuk
 */

@Component
public class SmsMessageTemplateTemplateLoader implements TemplateLoader {

    @Autowired
    private SmsMessageTemplateService smsMessageTemplateService;

    @Override
    public Object findTemplateSource(String name) throws IOException {
        return smsMessageTemplateService.getByType(name);
    }

    @Override
    public long getLastModified(Object templateSource) {
        SmsMessageTemplateDto smsMessageTemplateDto = (SmsMessageTemplateDto) templateSource;
        return smsMessageTemplateDto.getLastModified().getTime();
    }

    @Override
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        SmsMessageTemplateDto smsMessageTemplateDto = (SmsMessageTemplateDto) templateSource;
        return new StringReader(smsMessageTemplateDto.getTemplate());
    }

    @Override
    public void closeTemplateSource(Object templateSource) throws IOException {}
}
