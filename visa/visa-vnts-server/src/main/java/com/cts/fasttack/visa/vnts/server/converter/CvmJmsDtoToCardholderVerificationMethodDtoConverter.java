package com.cts.fasttack.visa.vnts.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.CvmJmsDto;
import com.cts.fasttack.visa.vnts.server.dict.OtpMethodPlatform;
import com.cts.fasttack.visa.vnts.server.dict.Type;
import com.cts.fasttack.visa.vnts.server.dto.CardholderVerificationMethodDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class CvmJmsDtoToCardholderVerificationMethodDtoConverter extends AbstractConverter<CvmJmsDto, CardholderVerificationMethodDto> {
    @Override
    protected CardholderVerificationMethodDto generateTarget() {
        return new CardholderVerificationMethodDto();
    }

    @Override
    protected void lightConvert(CvmJmsDto source, CardholderVerificationMethodDto target) {
        target.setIdentifier(source.getIdentifier());
        target.setOtpMethodPlatform(OtpMethodPlatform.getInstance(source.getOtpMethodPlatform()));
        target.setType(Type.getInstance(source.getType()));
        target.setValue(source.getValue());
        target.setSourceAddress(source.getSourceAddress());
    }
}
