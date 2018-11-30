package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dict.OsName;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.jms.dto.JmsAuthorizeServiceDto;
import org.springframework.stereotype.Component;

@Component
public class JmsAuthorizeServiceDtoToDeviceInfoConverter extends AbstractConverter<JmsAuthorizeServiceDto, DeviceInfoDto> {
    @Override
    protected DeviceInfoDto generateTarget() {
        return new DeviceInfoDto();
    }

    @Override
    protected void lightConvert(JmsAuthorizeServiceDto source, DeviceInfoDto target) {
        target.setDeviceName(source.getDeviceName());
        target.setImei(source.getImei());
        target.setOsName(OsName.getInstance(source.getOsName()));
        target.setOsVersion(source.getOsVersion());
        target.setSerialNumber(source.getSerialNumber());
        target.setStorageTechnology(source.getStorageTechnology());
        target.setDeviceType(source.getFormFactor());
    }
}
