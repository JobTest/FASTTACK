package com.cts.fasttack.bank.client.jms.processor;

import com.cts.fasttack.jms.converter.JmsCvmDtoConfirmProvisioningConverter;
import com.cts.fasttack.jms.dto.ConfirmProvisioningJmsMessage;
import com.cts.fasttack.jms.dto.CvmJmsMessage;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.jms.support.IntegrationBus;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class GetCardholderVerificationMethodsProcessor extends AbstractCamelProcessor<CvmJmsMessage, JmsConfirmProvisioningResponseDto> {

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private JmsCvmDtoConfirmProvisioningConverter jmsCvmDtoConfirmProvisioningConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, CvmJmsMessage.class, request -> integrationBus.inOut(request::getOriginator, "confirmProvisioning",
                    new ConfirmProvisioningJmsMessage().confirmProvisioningDto(
                            jmsCvmDtoConfirmProvisioningConverter.convert(request.getCvmDto())).originator(request.getOriginator()), JmsConfirmProvisioningResponseDto.class)
        );
    }
}
