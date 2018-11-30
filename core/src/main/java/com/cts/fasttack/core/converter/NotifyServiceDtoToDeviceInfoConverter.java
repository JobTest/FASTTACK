package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dict.OsName;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.jms.dto.JmsNotifyServiceDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class NotifyServiceDtoToDeviceInfoConverter extends AbstractConverter<JmsNotifyServiceDto, DeviceInfoDto> {
    @Override
    protected DeviceInfoDto generateTarget() {
        return new DeviceInfoDto();
    }

    @Override
    protected void lightConvert(JmsNotifyServiceDto source, DeviceInfoDto target) {
        target.setTokenRefId(source.getTokenUniqueReference());
        target.setDeviceName(source.getDeviceInfo().getDeviceName());
        target.setImei(source.getDeviceInfo().getImei());
        target.setOsName(OsName.getInstance(source.getDeviceInfo().getOsName()));
        target.setOsVersion(source.getDeviceInfo().getOsVersion());
        target.setSerialNumber(source.getDeviceInfo().getSerialNumber());
        target.setStorageTechnology(source.getDeviceInfo().getStorageTechnology());
        target.setDeviceType(source.getDeviceInfo().getFormFactor());
    }
}
