package com.cts.fasttack.visa.vnts.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.SendPasscodeJmsResponse;
import com.cts.fasttack.visa.vnts.server.dto.SendPasscodeResponseDto;

import org.springframework.stereotype.Component;

/**
 * @author d.ishchenko
 */
@Component
public class SendPasscodeJmsResponseToResponseConverter extends AbstractConverter<SendPasscodeJmsResponse, SendPasscodeResponseDto> {

    @Override
    protected SendPasscodeResponseDto generateTarget() {
        return new SendPasscodeResponseDto();
    }

    @Override
    protected void lightConvert(SendPasscodeJmsResponse source, SendPasscodeResponseDto target) {
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGuid(source.getPanInternalGuid());
        target.setMaskedPan(source.getMaskedPan());
    }
}
