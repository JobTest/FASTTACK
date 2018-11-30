package com.cts.fasttack.jms.dto;

/**
 * JMS device response DTO.
 *
 * @author v.semerkov
 */
public class JmsDeviceResponseDto {

    private String deviceId;

    private String deviceName;

    private String deviceType;

    private String secureElementId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getSecureElementId() {
        return secureElementId;
    }

    public void setSecureElementId(String secureElementId) {
        this.secureElementId = secureElementId;
    }
}
