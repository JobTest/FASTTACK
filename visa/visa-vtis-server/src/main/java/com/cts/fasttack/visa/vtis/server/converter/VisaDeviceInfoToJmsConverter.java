package com.cts.fasttack.visa.vtis.server.converter;

import com.cts.fasttack.visa.vtis.server.dto.VisaDeviceInfo;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsVtsDeviceInfo;

/**
 * @author Dmitry Koval
 */
@Component
public class VisaDeviceInfoToJmsConverter extends AbstractConverter<VisaDeviceInfo, JmsVtsDeviceInfo> {
    @Override
    protected JmsVtsDeviceInfo generateTarget() {
        return new JmsVtsDeviceInfo();
    }

    @Override
    protected void lightConvert(VisaDeviceInfo source, JmsVtsDeviceInfo target) {
        target.setDeviceID(source.getDeviceID());
        target.setDeviceLanguageCode(source.getDeviceLanguageCode());
        target.setOsType(source.getOsType());
        target.setOsVersion(source.getOsVersion());
        target.setOsBuildID(source.getOsBuildID());
        target.setDeviceType(source.getDeviceType());
        target.setDeviceIDType(source.getDeviceIDType());
        target.setDeviceManufacturer(source.getDeviceManufacturer());
        target.setDeviceBrand(source.getDeviceBrand());
        target.setDeviceModel(source.getDeviceModel());
        target.setDeviceName(source.getDeviceName());
        target.setDeviceNumber(source.getDeviceNumber());
        target.setDeviceLocation(source.getDeviceLocation());
        target.setDeviceIPAddressV4(source.getDeviceIPAddressV4());
        target.setLocationSource(source.getLocationSource());
        target.setTokenProtectionMethod(source.getTokenProtectionMethod());
        target.setStorageTechnology(source.getTokenProtectionMethod());
    }
}
