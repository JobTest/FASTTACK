package com.cts.fasttack.logging.interceptor.data;

public class AuthorizeTestObject {

    private String tokenRequestorId;

    private DeviceInfoTestObject deviceInfo;

    private String panInternalId;

    private String panInternalGuid;

    private String pan;

    private String panSource;

    public AuthorizeTestObject(String tokenRequestorId, DeviceInfoTestObject deviceInfo) {
        this.tokenRequestorId = tokenRequestorId;
        this.deviceInfo = deviceInfo;
    }

    public AuthorizeTestObject(String tokenRequestorId, DeviceInfoTestObject deviceInfo, String panInternalId, String panInternalGuid, String pan, String panSource) {
        this.tokenRequestorId = tokenRequestorId;
        this.deviceInfo = deviceInfo;
        this.panInternalId = panInternalId;
        this.panInternalGuid = panInternalGuid;
        this.pan = pan;
        this.panSource = panSource;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public DeviceInfoTestObject getDeviceInfo() {
        return deviceInfo;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public String getPanInternalGuid() {
        return panInternalGuid;
    }

    public String getPan() {
        return pan;
    }

    public String getPanSource() {
        return panSource;
    }
}
