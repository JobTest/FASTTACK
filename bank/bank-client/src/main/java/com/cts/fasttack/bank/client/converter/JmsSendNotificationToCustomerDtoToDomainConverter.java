package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.ObjectFactory;
import com.cts.fasttack.bank.client.ws.client.SendNotificationToCustomer;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsSendNotificationToCustomerRequestDto;
import org.springframework.stereotype.Component;

@Component
public class JmsSendNotificationToCustomerDtoToDomainConverter extends AbstractConverter<JmsSendNotificationToCustomerRequestDto, SendNotificationToCustomer> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Override
    protected SendNotificationToCustomer generateTarget() {
        return OBJECT_FACTORY.createSendNotificationToCustomer();
    }

    @Override
    protected void lightConvert(JmsSendNotificationToCustomerRequestDto source, SendNotificationToCustomer target) {

        target.setRequestId(source.getRequestId());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setTokenRefId(source.getTokenRefId());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGUID(source.getPanInternalGUID());
        target.setNotificationType(source.getNotificationType());
        target.setLastFourOfPAN(source.getLastFourOfPAN());
        target.setReminderPeriod(source.getReminderPeriod());
        target.setCustomerPhone(source.getCustomerPhone());
        target.setDeviceType(source.getDeviceType());
    }
}
