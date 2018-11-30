package com.cts.fasttack.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.core.dict.OsName;

/**
 * @author a.lipavets
 */
@Entity
@Table(name = "DEVICE_INFO")
public class DeviceInfo implements Identifiable<String> {

    @Id
    @Column(name = "TOKEN_REF_ID")
    private String tokenRefId;

    @Column(name = "DEVICE_NAME")
    private String deviceName;

    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @Column(name = "OS_NAME")
    @Enumerated(EnumType.STRING)
    private OsName osName;

    @Column(name = "OS_VERSION")
    private String osVersion;

    @Column(name = "IMEI")
    private String imei;

    @Column(name = "STORAGE_TECHNOLOGY")
    private String storageTechnology;

    @Column(name = "DEVICE_TYPE")
    private String deviceType;

    @Transient
    private boolean isNew = false;

    @Override
    public String getId() {
        return tokenRefId;
    }

    @Override
    public boolean isNew() {
        return isNew;
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

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
