package com.cts.fasttack.mdes.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsDeliverActivationCodeDto;
import com.cts.fasttack.mdes.server.dto.DeliverActivationCodeRequestDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class DeliverActivationCodeRequestDtoToJmsDtoConverter extends AbstractConverter<DeliverActivationCodeRequestDto, JmsDeliverActivationCodeDto> {

    @Override
    protected JmsDeliverActivationCodeDto generateTarget() {
        return new JmsDeliverActivationCodeDto();
    }

    @Override
    protected void lightConvert(DeliverActivationCodeRequestDto source, JmsDeliverActivationCodeDto target) {
        target.setActivationCode(source.getActivationCode());
        target.setActivationMethod(source.getActivationMethod().getType());
        target.setCorrelationId(source.getCorrelationId());
        target.setExpirationDateTime(source.getExpirationDateTime());
        target.setRequestId(source.getRequestId());
        target.setTokenUniqueReference(source.getTokenUniqueReference());
    }
}
