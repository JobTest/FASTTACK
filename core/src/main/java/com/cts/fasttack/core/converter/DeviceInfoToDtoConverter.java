package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.core.data.DeviceInfo;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import org.springframework.stereotype.Component;

/**
 * Convert {@link DeviceInfo} into {@link DeviceInfoDto}
 *
 * @author a.lipavets
 */
@Component
public class DeviceInfoToDtoConverter extends IdentifierToDtoConverter<String, DeviceInfo, DeviceInfoDto> {
    @Override
    protected DeviceInfoDto generateTarget() {
        return new DeviceInfoDto();
    }

    @Override
    public void convert(DeviceInfo source, DeviceInfoDto target) {
        target.setDeviceName(source.getDeviceName());
        target.setImei(source.getImei());
        target.setOsName(source.getOsName());
        target.setOsVersion(source.getOsVersion());
        target.setSerialNumber(source.getSerialNumber());
        target.setTokenRefId(source.getTokenRefId());
        target.setStorageTechnology(source.getStorageTechnology());
        target.setDeviceType(source.getDeviceType());
    }
}
