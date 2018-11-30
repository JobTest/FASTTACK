package com.cts.fasttack.jms.dto;

import java.util.List;

/**
 * @author a.lipavets
 * @author d.ishchenko
 */
public class CardholderVerificationMethodsJmsResponse extends BankJmsResponseDto {
    private List<CvmJmsDto> cardholderVerificationMethod;

    private String maskedPan;

    private String panInternalId;

    private String panInternalGuid;

    public List<CvmJmsDto> getCardholderVerificationMethod() {
        return cardholderVerificationMethod;
    }

    public void setCardholderVerificationMethod(List<CvmJmsDto> cardholderVerificationMethod) {
        this.cardholderVerificationMethod = cardholderVerificationMethod;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
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
}
