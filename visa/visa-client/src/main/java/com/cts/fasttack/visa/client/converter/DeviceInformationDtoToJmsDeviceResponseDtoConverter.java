package com.cts.fasttack.visa.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsDeviceResponseDto;
import com.cts.fasttack.visa.client.dto.DeviceInformationDto;

/**
 * {@link DeviceInformationDto} to {@link JmsDeviceResponseDto} converter.
 *
 * @author v.semerkov
 * @author d.ishchenko
 */
@Component
public class DeviceInformationDtoToJmsDeviceResponseDtoConverter extends AbstractConverter<DeviceInformationDto, JmsDeviceResponseDto> {

    @Override
    protected JmsDeviceResponseDto generateTarget() {
        return new JmsDeviceResponseDto();
    }

    @Override
    protected void lightConvert(DeviceInformationDto source, JmsDeviceResponseDto target) {
        target.setDeviceId(source.getSerialNumber());
        target.setDeviceName(source.getDeviceName());
        target.setDeviceType(toMdesStyleDeviceType(source.getDeviceType()));
        target.setSecureElementId(source.getSecureElementID());
    }

    private String toMdesStyleDeviceType(String deviceType) {
        if ("1".equals(deviceType) || "4".equals(deviceType)) {
            return "21";
        } else if ("2".equals(deviceType)) {
            return "22";
        } else if ("3".equals(deviceType)) {
            return "23";
        } else {
            return "99";
        }
    }
}
