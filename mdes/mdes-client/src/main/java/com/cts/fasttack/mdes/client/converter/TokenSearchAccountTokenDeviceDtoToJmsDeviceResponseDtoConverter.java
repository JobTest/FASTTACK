package com.cts.fasttack.mdes.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsDeviceResponseDto;
import com.cts.fasttack.jms.dto.TokenSearchAccountTokenDeviceDto;

/**
 * {@link TokenSearchAccountTokenDeviceDto} to {@link JmsDeviceResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class TokenSearchAccountTokenDeviceDtoToJmsDeviceResponseDtoConverter extends AbstractConverter<TokenSearchAccountTokenDeviceDto, JmsDeviceResponseDto> {

    @Override
    protected JmsDeviceResponseDto generateTarget() {
        return new JmsDeviceResponseDto();
    }

    @Override
    protected void lightConvert(TokenSearchAccountTokenDeviceDto source, JmsDeviceResponseDto target) {
        target.setDeviceId(source.getDeviceId());
        target.setDeviceName(source.getDeviceName());
        target.setDeviceType(source.getDeviceType());
        target.setSecureElementId(source.getSecureElementId());
    }
}
