package com.cts.fasttack.jms.dto;

/**
 * @author a.lipavets
 */
public class JmsDeviceInformationDto {

    private String secureElementID;

    private String deviceType;

    private String deviceNumber;

    private String deviceName;

    private String serialNumber;

    public String getSecureElementID() {
        return secureElementID;
    }

    public void setSecureElementID(String secureElementID) {
        this.secureElementID = secureElementID;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
