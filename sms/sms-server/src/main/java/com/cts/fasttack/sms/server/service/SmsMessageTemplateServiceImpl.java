package com.cts.fasttack.sms.server.service;

import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.sms.server.converter.SmsMessageTemplateDtoToDomainConverter;
import com.cts.fasttack.sms.server.converter.SmsMessageTemplateToDtoConverter;
import com.cts.fasttack.sms.server.dao.SmsMessageTemplateDao;
import com.cts.fasttack.sms.server.data.SmsMessageTemplate;
import com.cts.fasttack.sms.server.dto.SmsMessageTemplateDto;
import com.cts.fasttack.sms.server.freemarker.SmsMessageTemplateTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

/**
 * @author Anton Leliuk
 */
@Service
public class SmsMessageTemplateServiceImpl extends GenericServiceImpl<Long, SmsMessageTemplateDto, SmsMessageTemplate, SmsMessageTemplateDao> implements SmsMessageTemplateService {

    private Configuration configuration;

    @Autowired
    private SmsMessageTemplateTemplateLoader smsMessageTemplateTemplateLoader;

    @PostConstruct
    public void init(){
        configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setTemplateLoader(smsMessageTemplateTemplateLoader);
    }

    @Autowired
    public SmsMessageTemplateServiceImpl(SmsMessageTemplateDao dao, SmsMessageTemplateToDtoConverter domainToDtoConverter, SmsMessageTemplateDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Transactional(readOnly = true)
    @Override
    public SmsMessageTemplateDto getByType(String type) {
        return domainToDtoConverter.convert(dao.getByType(type));
    }

    @Override
    public String evaluateTemplate(String type, Map<String, Object> parametersTemplate) throws IOException, TemplateException {
        return FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate(type), parametersTemplate);
    }
}
