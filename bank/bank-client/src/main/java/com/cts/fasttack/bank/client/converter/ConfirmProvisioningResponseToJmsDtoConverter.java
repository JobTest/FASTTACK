package com.cts.fasttack.bank.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.client.ws.client.ConfirmProvisioningResponse;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsConfirmProvisioningResponseDto;

/**
 * @author Dmitry Koval
 */
@Component
public class ConfirmProvisioningResponseToJmsDtoConverter extends AbstractConverter<ConfirmProvisioningResponse, JmsConfirmProvisioningResponseDto> {

    @Override
    protected JmsConfirmProvisioningResponseDto generateTarget() {
        return new JmsConfirmProvisioningResponseDto();
    }

    @Override
    protected void lightConvert(ConfirmProvisioningResponse source, JmsConfirmProvisioningResponseDto target) {
        target.setCode(source.getCode() != null ? source.getCode().getValue() : null);
        target.setCustomerPhone(source.getCustomerPhone() != null ? source.getCustomerPhone().getValue() : null);
        target.setDecision(source.getDecision() != null ? source.getDecision().getValue() : null);
        target.setErrorMessage(source.getErrorMessage() != null ? source.getErrorMessage().getValue() : null);
        target.setPanInternalGUID(source.getPanInternalGUID() != null ? source.getPanInternalGUID().getValue() : null);
        target.setPanInternalId(source.getPanInternalId() != null ? source.getPanInternalId().getValue() : null);
        target.setProductConfigID(source.getProductConfigID() != null ? source.getProductConfigID().getValue() : null);
    }
}
