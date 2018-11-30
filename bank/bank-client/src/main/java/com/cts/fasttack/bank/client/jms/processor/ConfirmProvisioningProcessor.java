package com.cts.fasttack.bank.client.jms.processor;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.client.converter.ConfirmProvisioningResponseToJmsDtoConverter;
import com.cts.fasttack.bank.client.converter.JmsConfirmProvisioningDtoToDomainConverter;
import com.cts.fasttack.bank.client.ws.service.ConfirmProvisioningService;
import com.cts.fasttack.bank.client.ws.client.ConfirmProvisioning;
import com.cts.fasttack.bank.client.ws.client.ConfirmProvisioningResponse;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.jms.dto.ConfirmProvisioningJmsMessage;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;

/**
 * Processor Confirm Provisioning
 *
 * @author Dmitry Koval
 */
@Component
public class ConfirmProvisioningProcessor extends AbstractCamelProcessor<ConfirmProvisioningJmsMessage, JmsConfirmProvisioningResponseDto> {

    private Logger logger = LogManager.getLogger(ConfirmProvisioningProcessor.class);

    @Autowired
    private JmsConfirmProvisioningDtoToDomainConverter jmsConfirmProvisioningDtoToDomainConverter;

    @Autowired
    private ConfirmProvisioningResponseToJmsDtoConverter confirmProvisioningResponseToJmsDtoConverter;

    @Autowired
    private ConfirmProvisioningService confirmProvisioningService;

    @Autowired
    private AlertLogService alertLogService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, ConfirmProvisioningJmsMessage.class, request -> {
            ConfirmProvisioning requestDto = jmsConfirmProvisioningDtoToDomainConverter.convert(request.getJmsConfirmProvisioningDto());
            ConfirmProvisioningResponse responseDto = confirmProvisioningService.confirmProvisioning(requestDto);

            JmsConfirmProvisioningResponseDto jmsResponse = confirmProvisioningResponseToJmsDtoConverter.convert(responseDto);

            if ("2".equals(jmsResponse.getCode())) {
                throw new ServiceException(StandardErrorCodes.NO_DATA_FOUND);
            }
            if (StringUtils.isBlank(jmsResponse.getPanInternalId()) && StringUtils.isBlank(jmsResponse.getPanInternalGUID())) {
                AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                        .with(AlertLogDto::setEvent, "REQUIRED_FIELDS_NOT_FILLED")
                        .with(AlertLogDto::setOriginator, request.getOriginator())
                        .with(AlertLogDto::setData, "Required fields not filled: panInternalGUID - " + jmsResponse.getPanInternalGUID() + "; panInternalId - " + jmsResponse.getPanInternalId())
                        .with(AlertLogDto::setDate, new Date())
                        .build();
                alertLogService.save(alertLogDto);
                logger.info(alertLogDto.getData());
                throw new ServiceException(StandardErrorCodes.INTERNAL_SERVICE_FAILURE);
            }
            if (requestDto.getPanSource().equalsIgnoreCase("K") && StringUtils.isBlank(jmsResponse.getCustomerPhone())) {
                jmsResponse.setDecision("REQUIRE_ADDITIONAL_AUTHENTICATION");
                return jmsResponse;
            }
            return jmsResponse;
        }
        );
    }
}
