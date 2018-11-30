package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.DeviceInfo;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import org.springframework.stereotype.Component;

/**
 * Convert {@linkDeviceInfoDto} into {@link DeviceInfo}
 * @author a.lipavets
 */
@Component
public class DeviceInfoDtoToDomainConverter extends AbstractConverter<DeviceInfoDto, DeviceInfo> {
    @Override
    protected DeviceInfo generateTarget() {
        return new DeviceInfo();
    }

    @Override
    protected void lightConvert(DeviceInfoDto source, DeviceInfo target) {
        target.setDeviceName(source.getDeviceName());
        target.setImei(source.getImei());
        target.setOsName(source.getOsName());
        target.setOsVersion(source.getOsVersion());
        target.setSerialNumber(source.getSerialNumber());
        target.setTokenRefId(source.getTokenRefId());
        target.setNew(source.isNew());
        target.setStorageTechnology(source.getStorageTechnology());
        target.setDeviceType(source.getDeviceType());
    }
}
