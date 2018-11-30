package com.cts.fasttack.visa.vnts.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.jms.dto.CardholderVerificationMethodsJmsResponse;
import com.cts.fasttack.visa.common.dict.ActionCode;
import com.cts.fasttack.visa.vnts.server.dto.CardholderVerificationMethodResponseDto;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class CardholderVerificationMethodsJmsResponseToResponseConverter extends AbstractConverter<CardholderVerificationMethodsJmsResponse, CardholderVerificationMethodResponseDto> {

    @Autowired
    private CvmJmsDtoToCardholderVerificationMethodDtoConverter cvmJmsDtoToCardholderVerificationMethodDtoConverter;

    @Override
    protected CardholderVerificationMethodResponseDto generateTarget() {
        return new CardholderVerificationMethodResponseDto();
    }

    @Override
    protected void lightConvert(CardholderVerificationMethodsJmsResponse source, CardholderVerificationMethodResponseDto target) {
        if(StringUtils.isNotBlank(source.getCode())){
            if(!"0".equals(source.getCode())){
                target.setActionCode(ActionCode.FAILURE.getCode());
                target.setErrorCode(VisaErrorCode.Codes.INTERNAL_SERVICE_FAILURE);
            }
        }
        target.setCardholderVerificationMethod(cvmJmsDtoToCardholderVerificationMethodDtoConverter.convert(source.getCardholderVerificationMethod()));
        target.setMaskedPan(source.getMaskedPan());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGuid(source.getPanInternalGuid());
    }
}
