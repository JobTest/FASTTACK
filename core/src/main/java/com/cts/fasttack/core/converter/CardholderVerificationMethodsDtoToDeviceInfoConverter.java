package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.jms.dto.JmsCardholderVerificationMethodsDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class CardholderVerificationMethodsDtoToDeviceInfoConverter extends AbstractConverter<JmsCardholderVerificationMethodsDto, DeviceInfoDto> {
    @Override
    protected DeviceInfoDto generateTarget() {
        return new DeviceInfoDto();
    }

    @Override
    protected void lightConvert(JmsCardholderVerificationMethodsDto source, DeviceInfoDto target) {
        target.setDeviceName(source.getDeviceName());
        target.setImei(source.getSecureElementID());
        target.setSerialNumber(source.getDeviceNumber());
        target.setTokenRefId(source.getTokenReferenceID());
        target.setDeviceType(source.getDeviceType());
    }
}
