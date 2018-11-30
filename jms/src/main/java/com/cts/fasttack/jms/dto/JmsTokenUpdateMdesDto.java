package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsTokenUpdateMdesDto {
    private String newAccountPan;

    private JmsCurrentFinancialAccountInformationDto currentFinancialAccountInformation;

    private String newFinancialAccountId;

    private String expirationDate;

    private String accountPanSequenceNumber;

    private String issuerProductConfigurationId;

    private String updateWalletProviderIndicator;

    private String tokenUniqueReference;

    private String commentText;

    private String reasonCode;

    private JmsAuditInfoDto auditInfo;

    public String getNewAccountPan() {
        return newAccountPan;
    }

    public void setNewAccountPan(String newAccountPan) {
        this.newAccountPan = newAccountPan;
    }

    public JmsCurrentFinancialAccountInformationDto getCurrentFinancialAccountInformation() {
        return currentFinancialAccountInformation;
    }

    public void setCurrentFinancialAccountInformation(JmsCurrentFinancialAccountInformationDto currentFinancialAccountInformation) {
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

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public JmsAuditInfoDto getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(JmsAuditInfoDto auditInfo) {
        this.auditInfo = auditInfo;
    }
}
