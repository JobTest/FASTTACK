package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsConfirmProvisioningResponseDto extends BankJmsResponseDto {

    private String decision;

    private String panInternalId;

    private String panInternalGUID;

    private String customerPhone;

    private String productConfigID;

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getPanInternalId() {
        return panInternalId;
    }

    public void setPanInternalId(String panInternalId) {
        this.panInternalId = panInternalId;
    }

    public String getPanInternalGUID() {
        return panInternalGUID;
    }

    public void setPanInternalGUID(String panInternalGUID) {
        this.panInternalGUID = panInternalGUID;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getProductConfigID() {
        return productConfigID;
    }

    public void setProductConfigID(String productConfigID) {
        this.productConfigID = productConfigID;
    }
}
