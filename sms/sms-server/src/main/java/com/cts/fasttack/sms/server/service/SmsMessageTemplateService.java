package com.cts.fasttack.sms.server.service;

import java.io.IOException;
import java.util.Map;

import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.sms.server.data.SmsMessageTemplate;
import com.cts.fasttack.sms.server.dto.SmsMessageTemplateDto;

import freemarker.template.TemplateException;

/**
 * @author Anton Leliuk
 */
public interface SmsMessageTemplateService extends GenericService<Long, SmsMessageTemplateDto, SmsMessageTemplate> {

    SmsMessageTemplateDto getByType(String type);

    String evaluateTemplate(String type, Map<String, Object> parametersTemplate) throws IOException, TemplateException;
}
