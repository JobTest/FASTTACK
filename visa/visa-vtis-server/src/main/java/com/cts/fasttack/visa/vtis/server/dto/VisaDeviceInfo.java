package com.cts.fasttack.visa.vtis.server.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.dict.VisaErrorCode;
import com.cts.fasttack.common.core.validation.ValidEnum;
import com.cts.fasttack.visa.vtis.server.dict.DeviceType;
import com.cts.fasttack.visa.vtis.server.dict.LocationSource;
import com.cts.fasttack.visa.vtis.server.dict.OsType;
import com.cts.fasttack.visa.vtis.server.dict.TokenProtectionMethod;

/**
 * @author Dmitry Koval
 */
public class VisaDeviceInfo {

    @Size(max = 48, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String deviceID;

    @Size(min = 3, max = 3, message = VisaErrorCode.Names.INVALID_FIELD_LENGTH)
    private String deviceLanguageCode;

    @ValidEnum(enumType = OsType.class, message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String osType;

    private String osVersion;

    private String osBuildID;

    @ValidEnum(enumType = DeviceType.class, message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String deviceType;

    private String deviceIDType;

    private String deviceManufacturer;

    private String deviceBrand;

    private String deviceModel;

    private String deviceName;

    private String deviceNumber;

    private String deviceLocation;

    @Pattern(regexp = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^$",
            message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String deviceIPAddressV4;


    @ValidEnum(enumType = LocationSource.class, message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String locationSource;

    @ValidEnum(enumType = TokenProtectionMethod.class, message = VisaErrorCode.Names.INVALID_FIELD_TYPE)
    private String tokenProtectionMethod;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceLanguageCode() {
        return deviceLanguageCode;
    }

    public void setDeviceLanguageCode(String deviceLanguageCode) {
        this.deviceLanguageCode = deviceLanguageCode;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsBuildID() {
        return osBuildID;
    }

    public void setOsBuildID(String osBuildID) {
        this.osBuildID = osBuildID;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceIDType() {
        return deviceIDType;
    }

    public void setDeviceIDType(String deviceIDType) {
        this.deviceIDType = deviceIDType;
    }

    public String getDeviceManufacturer() {
        return deviceManufacturer;
    }

    public void setDeviceManufacturer(String deviceManufacturer) {
        this.deviceManufacturer = deviceManufacturer;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getDeviceIPAddressV4() {
        return deviceIPAddressV4;
    }

    public void setDeviceIPAddressV4(String deviceIPAddressV4) {
        this.deviceIPAddressV4 = deviceIPAddressV4;
    }

    public String getLocationSource() {
        return locationSource;
    }

    public void setLocationSource(String locationSource) {
        this.locationSource = locationSource;
    }

    public String getTokenProtectionMethod() {
        return tokenProtectionMethod;
    }

    public void setTokenProtectionMethod(String tokenProtectionMethod) {
        this.tokenProtectionMethod = tokenProtectionMethod;
    }
}
