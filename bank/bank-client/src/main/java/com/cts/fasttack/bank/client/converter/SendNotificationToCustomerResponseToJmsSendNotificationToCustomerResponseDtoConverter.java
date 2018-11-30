package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.SendNotificationToCustomerResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerResponseDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SendNotificationToCustomerResponseToJmsSendNotificationToCustomerResponseDtoConverter extends AbstractConverter<SendNotificationToCustomerResponse, JmsSendNotificationToCustomerResponseDto> {
    @Override
    protected JmsSendNotificationToCustomerResponseDto generateTarget() {
        return new JmsSendNotificationToCustomerResponseDto();
    }

    @Override
    protected void lightConvert(SendNotificationToCustomerResponse source, JmsSendNotificationToCustomerResponseDto target) {
        target.setRequestId(source.getRequestId().getValue());
        target.setCode(source.getCode().getValue());
        Optional.ofNullable(source.getErrorMessage()).ifPresent(e -> target.setErrorMessage(e.getValue()));
    }
}
