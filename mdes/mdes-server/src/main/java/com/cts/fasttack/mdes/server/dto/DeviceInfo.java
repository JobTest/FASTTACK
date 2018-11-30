package com.cts.fasttack.mdes.server.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.mdes.server.dict.FormFactor;
import com.cts.fasttack.mdes.server.dict.OsName;
import com.cts.fasttack.mdes.server.dict.PaymentType;
import com.cts.fasttack.mdes.server.dict.StorageTechnology;
import com.cts.fasttack.common.core.validation.ValidEnum;
import com.cts.fasttack.mdes.server.validation.ValidEnumArray;

/**
 * Contains information about the target device to be provisioned
 *
 * @author a.lipavets
 */
public class DeviceInfo {

    /**
     * The name that the Cardholder has associated to the device with the Payment App Provider
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String deviceName;

    /**
     * The serial number of the device
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String serialNumber;

    /**
     * The form factor of the device to be provisioned
     */
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = FormFactor.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String formFactor;

    /**
     * The 2 digit device type provided on the iso messages that the token is being provisioned to
     */
    @Size(max = 2, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String isoDeviceType;

    /**
     * The name of the device operating system
     */
    @Size(max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @ValidEnum(enumType = OsName.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String osName;

    /**
     * The version of the device operating system
     */
    @Size(max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String osVersion;

    /**
     * The IMEI number of the device being provisioned
     */
    @Size(max = 15, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String imei;

    /**
     * The MSISDN of the device being provisioned
     */
    @Size(max = 15, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String msisdn;

    /**
     * Different types of Payments supported for the token
     */

    @Valid
    @ValidEnumArray(enumType = PaymentType.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private List<String> paymentTypes;

    /**
     * The architecture or technology used for token storage
     */
    @ValidEnum(enumType = StorageTechnology.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String storageTechnology;

    /**
     * getters and setters
     */
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

    public String getIsoDeviceType() {
        return isoDeviceType;
    }

    public void setIsoDeviceType(String isoDeviceType) {
        this.isoDeviceType = isoDeviceType;
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

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public List<String> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<String> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public String getStorageTechnology() {
        return storageTechnology;
    }

    public void setStorageTechnology(String storageTechnology) {
        this.storageTechnology = storageTechnology;
    }
}
