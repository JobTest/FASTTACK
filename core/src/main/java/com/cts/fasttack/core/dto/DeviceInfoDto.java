package com.cts.fasttack.core.dto;


import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.core.dict.OsName;
import org.apache.commons.lang3.StringUtils;

/**
 * DTO for {@link com.cts.fasttack.core.data.DeviceInfo}
 *
 * @author a.lipavets
 */
public class DeviceInfoDto extends IdentifierDto<String> {

    private String tokenRefId;

    private String deviceName;

    private String serialNumber;

    private OsName osName;

    private String osVersion;

    private String imei;

    private String storageTechnology;

    private String deviceType;

    @Override
    public boolean isNew() {
        return StringUtils.isBlank(getTokenRefId());
    }

    public String getTokenRefId() {
        return tokenRefId;
    }

    public void setTokenRefId(String tokenRefId) {
        this.tokenRefId = tokenRefId;
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

    public OsName getOsName() {
        return osName;
    }

    public void setOsName(OsName osName) {
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

    public String getStorageTechnology() {
        return storageTechnology;
    }

    public void setStorageTechnology(String storageTechnology) {
        this.storageTechnology = storageTechnology;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
