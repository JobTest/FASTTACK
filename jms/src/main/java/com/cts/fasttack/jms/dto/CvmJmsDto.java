package com.cts.fasttack.jms.dto;

/**
 * @author a.lipavets
 */
public class CvmJmsDto {

    private String type;

    private String value;

    private String identifier;

    private String sourceAddress;

    private String otpMethodPlatform;

    /* getters and setters */

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getOtpMethodPlatform() {
        return otpMethodPlatform;
    }

    public void setOtpMethodPlatform(String otpMethodPlatform) {
        this.otpMethodPlatform = otpMethodPlatform;
    }
}
