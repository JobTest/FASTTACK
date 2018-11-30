package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.core.dict.OsName;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.jms.dto.JmsVtsDeviceInfo;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsVtsDeviceInfoToDtoConverter {

    public DeviceInfoDto convert(JmsVtsDeviceInfo source, TokenInfoDto tokenInfoDto) {
        DeviceInfoDto target = new DeviceInfoDto();
        target.setDeviceName(source.getDeviceName());
        target.setOsName(OsName.getInstance(source.getOsType()));
        target.setOsVersion(source.getOsVersion());
        target.setTokenRefId(tokenInfoDto.getId().getTokenRefId());
        target.setStorageTechnology(source.getTokenProtectionMethod());
        target.setDeviceType(source.getDeviceType());
        return target;
    }
}
