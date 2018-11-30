package com.cts.fasttack.jms.dto;

/**
 * @author Anton Leliuk
 */
public class JmsNotifyServiceDeviceInfoDto {

    private String deviceName;

    private String serialNumber;

    private String formFactor;

    private String isoDeviceType;

    private String osName;

    private String osVersion;

    private String imei;

    private String msisdn;

    private String storageTechnology;

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

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getIsoDeviceType() {
        return isoDeviceType;
    }

    public void setIsoDeviceType(String isoDeviceType) {
        this.isoDeviceType = isoDeviceType;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getStorageTechnology() {
        return storageTechnology;
    }

    public void setStorageTechnology(String storageTechnology) {
        this.storageTechnology = storageTechnology;
    }
}
