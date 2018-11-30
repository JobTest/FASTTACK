package com.cts.fasttack.logging.interceptor.data;

public class DeviceInfoTestObject {

    private String deviceName;

    private String serialNumber;

    private String osName;

    private String osVersion;

    private String[] paymentTypes;

    public DeviceInfoTestObject(String deviceName, String serialNumber, String osName, String osVersion, String[] paymentTypes) {
        this.deviceName = deviceName;
        this.serialNumber = serialNumber;
        this.osName = osName;
        this.osVersion = osVersion;
        this.paymentTypes = paymentTypes;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getOsName() {
        return osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String[] getPaymentTypes() {
        return paymentTypes;
    }
}
