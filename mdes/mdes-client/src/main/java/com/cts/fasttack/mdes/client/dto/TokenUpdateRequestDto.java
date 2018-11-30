package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author a.lipavets
 */
@XmlRootElement(name = "TokenUpdateRequest")
@JsonRootName("TokenUpdateRequest")
public class TokenUpdateRequestDto extends AbstractTokenLifecycleRequestDto {

    @XmlElement(name = "NewAccountPan")
    @JsonProperty("NewAccountPan")
    private String newAccountPan;

    @XmlElement(name = "CurrentFinancialAccountInformation")
    @JsonProperty("CurrentFinancialAccountInformation")
    private CurrentFinancialAccountInformationDto currentFinancialAccountInformation;

    @XmlElement(name = "NewFinancialAccountId")
    @JsonProperty("NewFinancialAccountId")
    private String newFinancialAccountId;

    @XmlElement(name = "ExpirationDate")
    @JsonProperty("ExpirationDate")
    private String expirationDate;

    @XmlElement(name = "AccountPanSequenceNumber")
    @JsonProperty("AccountPanSequenceNumber")
    private String accountPanSequenceNumber;

    @XmlElement(name = "IssuerProductConfigurationId")
    @JsonProperty("IssuerProductConfigurationId")
    private String issuerProductConfigurationId;

    @XmlElement(name = "UpdateWalletProviderIndicator")
    @JsonProperty("UpdateWalletProviderIndicator")
    private String updateWalletProviderIndicator;

    public String getNewAccountPan() {
        return newAccountPan;
    }

    public void setNewAccountPan(String newAccountPan) {
        this.newAccountPan = newAccountPan;
    }

    public CurrentFinancialAccountInformationDto getCurrentFinancialAccountInformation() {
        return currentFinancialAccountInformation;
    }

    public void setCurrentFinancialAccountInformation(CurrentFinancialAccountInformationDto currentFinancialAccountInformation) {
        this.currentFinancialAccountInformation = currentFinancialAccountInformation;
    }

    public String getNewFinancialAccountId() {
        return newFinancialAccountId;
    }

    public void setNewFinancialAccountId(String newFinancialAccountId) {
        this.newFinancialAccountId = newFinancialAccountId;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAccountPanSequenceNumber() {
        return accountPanSequenceNumber;
    }

    public void setAccountPanSequenceNumber(String accountPanSequenceNumber) {
        this.accountPanSequenceNumber = accountPanSequenceNumber;
    }

    public String getIssuerProductConfigurationId() {
        return issuerProductConfigurationId;
    }

    public void setIssuerProductConfigurationId(String issuerProductConfigurationId) {
        this.issuerProductConfigurationId = issuerProductConfigurationId;
    }

    public String getUpdateWalletProviderIndicator() {
        return updateWalletProviderIndicator;
    }

    public void setUpdateWalletProviderIndicator(String updateWalletProviderIndicator) {
        this.updateWalletProviderIndicator = updateWalletProviderIndicator;
    }
}
