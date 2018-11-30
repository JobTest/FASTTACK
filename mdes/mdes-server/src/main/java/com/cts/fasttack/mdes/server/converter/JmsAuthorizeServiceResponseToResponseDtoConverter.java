package com.cts.fasttack.mdes.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceResponseDto;
import com.cts.fasttack.mdes.server.dict.AddressValidationStatus;
import com.cts.fasttack.mdes.server.dict.CvcValidationStatus;
import com.cts.fasttack.mdes.server.dto.AuthorizeServiceResponseDto;

/**
 * @author a.lipavets
 */
@Component
public class JmsAuthorizeServiceResponseToResponseDtoConverter extends AbstractConverter<JmsAuthorizeServiceResponseDto, AuthorizeServiceResponseDto> {

    @Autowired
    private ActivationMethodDtoToDomainConverter activationMethodDtoToDomainConverter;

    @Override
    protected AuthorizeServiceResponseDto generateTarget() {
        return new AuthorizeServiceResponseDto();
    }

    @Override
    protected void lightConvert(JmsAuthorizeServiceResponseDto source, AuthorizeServiceResponseDto target) {
        target.setResponseId(source.getResponseId());
        target.setDecision(source.getDecision());
        target.setActivationMethods(activationMethodDtoToDomainConverter.convert(source.getActivationMethods()));
        target.setAvsResponse(AddressValidationStatus.getInstance(source.getAvsResponse()));
        target.setCvcResponse(CvcValidationStatus.getInstance(source.getCvcResponse()));
        target.setIssuerProductConfigId(source.getIssuerProductConfigId());
        target.setServices(source.getServices());
        target.setTokenRequestorId(source.getTokenRequestorId());
        target.setMaskedPan(source.getMaskedPan());
        target.setPanSource(source.getPanSource());
        target.setPanInternalGuid(source.getPanInternalGuid());
        target.setPanInternalId(source.getPanInternalId());
    }
}
