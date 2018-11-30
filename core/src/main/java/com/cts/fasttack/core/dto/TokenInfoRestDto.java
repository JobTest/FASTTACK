package com.cts.fasttack.core.dto;

/**
 * @author Dmitry Koval
 */
public class TokenInfoRestDto extends TokenInfoDto {

    private DeviceInfoDto deviceInfo;

    public DeviceInfoDto getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoDto deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
