package com.cts.fasttack.mdes.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsNotifyServiceDeviceInfoDto;
import com.cts.fasttack.mdes.server.dto.DeviceInfo;
import org.springframework.stereotype.Component;

/**
 * @author Anton Leliuk
 */
@Component
public class DeviceInfoToJmsDeviceInfoDtoConverter extends AbstractConverter<DeviceInfo, JmsNotifyServiceDeviceInfoDto> {
    @Override
    protected JmsNotifyServiceDeviceInfoDto generateTarget() {
        return new JmsNotifyServiceDeviceInfoDto();
    }

    @Override
    protected void lightConvert(DeviceInfo source, JmsNotifyServiceDeviceInfoDto target) {
        target.setDeviceName(source.getDeviceName());
        target.setFormFactor(source.getFormFactor());
        target.setImei(source.getImei());
        target.setIsoDeviceType(source.getIsoDeviceType());
        target.setMsisdn(source.getMsisdn());
        target.setOsName(source.getOsName());
        target.setOsVersion(source.getOsVersion());
        target.setSerialNumber(source.getSerialNumber());
        target.setStorageTechnology(source.getStorageTechnology());
    }
}
