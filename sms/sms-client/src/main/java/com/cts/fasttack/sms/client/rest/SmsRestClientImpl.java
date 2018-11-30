package com.cts.fasttack.sms.client.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.rest.client.RestClientImpl;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.sms.client.conf.SmsClientConfigurationProperties;
import com.cts.fasttack.sms.client.dto.SmsRestRequestDto;

/**
 * @author Dmitry Koval
 */
@Component
@ConditionalOnProperty(prefix = "spring.sms.server", value = "address")
public class SmsRestClientImpl extends RestClientImpl implements SmsRestClient {

    @Autowired
    public SmsRestClientImpl(@Qualifier("smsServerRestTemplate") RestTemplate restTemplate, SmsClientConfigurationProperties properties) {
        super(restTemplate, properties.getAddress());
    }

    @Override
    public void send(String type, String phone, Map<String, Object> templateParameters) throws ServiceException {
        post("/sms/client/send",  GenericBuilder.of(SmsRestRequestDto::new)
                .with(SmsRestRequestDto::setType, type)
                .with(SmsRestRequestDto::setPhone, phone)
                .with(SmsRestRequestDto::setTemplateParameters, templateParameters)
                .build(), Void.class);
    }
}
