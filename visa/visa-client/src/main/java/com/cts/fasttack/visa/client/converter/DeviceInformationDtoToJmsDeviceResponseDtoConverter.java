package com.cts.fasttack.visa.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsDeviceResponseDto;
import com.cts.fasttack.visa.client.dto.DeviceInformationDto;

/**
 * {@link DeviceInformationDto} to {@link JmsDeviceResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class DeviceInformationDtoToJmsDeviceResponseDtoConverter extends AbstractConverter<DeviceInformationDto, JmsDeviceResponseDto> {

    @Override
    protected JmsDeviceResponseDto generateTarget() {
        return new JmsDeviceResponseDto();
    }

    @Override
    protected void lightConvert(DeviceInformationDto source, JmsDeviceResponseDto target) {
        target.setDeviceName(source.getDeviceName());
        target.setDeviceType(source.getDeviceType());
        target.setSecureElementId(source.getSecureElementID());
    }
}
