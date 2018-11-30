package com.cts.fasttack.jms.dto;

/**
 * @author d.ishchenko
 */
public class SendPasscodeJmsResponse extends BankJmsResponseDto {
    private String panInternalId;

    private String panInternalGuid;
    
    private String maskedPan;

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

	public String getMaskedPan() {
		return maskedPan;
	}

	public void setMaskedPan(String maskedPan) {
		this.maskedPan = maskedPan;
	}
}
