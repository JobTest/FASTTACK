package com.cts.fasttack.visa.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsDeviceInformationDto;
import com.cts.fasttack.visa.client.dto.DeviceInformationDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class DeviceInfoToJmsDtoConverter extends AbstractConverter<DeviceInformationDto, JmsDeviceInformationDto> {
    @Override
    protected JmsDeviceInformationDto generateTarget() {
        return new JmsDeviceInformationDto();
    }

    @Override
    protected void lightConvert(DeviceInformationDto source, JmsDeviceInformationDto target) {
        target.setDeviceName(source.getDeviceName());
        target.setDeviceNumber(source.getDeviceNumber());
        target.setDeviceType(source.getDeviceType());
        target.setSecureElementID(source.getSecureElementID());
        target.setSerialNumber(source.getSerialNumber());
    }
}
