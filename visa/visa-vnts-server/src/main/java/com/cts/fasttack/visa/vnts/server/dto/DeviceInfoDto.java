package com.cts.fasttack.visa.vnts.server.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.dict.VisaErrorCode;

/**
 * Device Info object
 *
 * @author a.lipavets
 */
public class DeviceInfoDto {

    /**
     * SE ID (Secure Element ID) represents the device ID.
     */
    @Size(max = 48, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String secureElementID;

    /**
     * DeviceType for Visa
     */
    @Size(max = 2, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    @Min(value = 0L, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    @Max(value = 99L, message = VisaErrorCode.Codes.INVALID_FIELD_TYPE)
    private String deviceType;

    /**
     * In some DWP implementations, this will be the full mobile number and in
     * other cases only the last 4 digits of the mobile number will be provided
     */
    @Size(min = 1, max = 13, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String deviceNumber;

    /**
     * User assigned device name
     */
    @Size(min = 1, max = 16, message = VisaErrorCode.Codes.INVALID_FIELD_LENGTH)
    private String deviceName;

    /* getters and setters*/

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
}
