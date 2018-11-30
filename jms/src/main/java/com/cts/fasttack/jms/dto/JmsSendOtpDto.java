package com.cts.fasttack.jms.dto;

/**
 * @author a.lipavets
 */
public class JmsSendOtpDto {

    private String requestId;

    private String conversationId;

    private String panInternalId;

    private String panInternalGuid;

    private String otp;

    private String customerPhone;
    
    private String tokenRefId;
    
    private String maskedPan;

    private String deviceType;

    private String tokenRequestorId;

    private String lastFourOfPAN;

    /** getters and setters */

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public String getPanInternalGuid() {
        return panInternalGuid;
    }

    public void setPanInternalGuid(String panInternalGuid) {
        this.panInternalGuid = panInternalGuid;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

	public String getTokenRefId() {
		return tokenRefId;
	}

	public void setTokenRefId(String tokenRefId) {
		this.tokenRefId = tokenRefId;
	}

	public String getMaskedPan() {
		return maskedPan;
	}

	public void setMaskedPan(String maskedPan) {
		this.maskedPan = maskedPan;
	}

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getTokenRequestorId() {
        return tokenRequestorId;
    }

    public void setTokenRequestorId(String tokenRequestorId) {
        this.tokenRequestorId = tokenRequestorId;
    }

    public String getLastFourOfPAN() {
        return lastFourOfPAN;
    }

    public void setLastFourOfPAN(String lastFourOfPAN) {
        this.lastFourOfPAN = lastFourOfPAN;
    }
}
