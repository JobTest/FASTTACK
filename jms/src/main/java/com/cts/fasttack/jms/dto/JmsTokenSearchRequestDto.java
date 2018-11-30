package com.cts.fasttack.jms.dto;

/**
 * @author Dmitry Koval
 */
public class JmsTokenSearchRequestDto {

    private String accountPan;

    private String tokenUniqueReference;

    private String token;

    private String paymentAppInstanceId;

    private String commentId;

    private String alternateAccountIdentifier;

    private String financialAccountInformation;

    private boolean excludeDeletedIndicator;

    private JmsAuditInfoDto auditInfo;

    public String getAccountPan() {
        return accountPan;
    }

    public void setAccountPan(String accountPan) {
        this.accountPan = accountPan;
    }

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPaymentAppInstanceId() {
        return paymentAppInstanceId;
    }

    public void setPaymentAppInstanceId(String paymentAppInstanceId) {
        this.paymentAppInstanceId = paymentAppInstanceId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getAlternateAccountIdentifier() {
        return alternateAccountIdentifier;
    }

    public void setAlternateAccountIdentifier(String alternateAccountIdentifier) {
        this.alternateAccountIdentifier = alternateAccountIdentifier;
    }

    public String getFinancialAccountInformation() {
        return financialAccountInformation;
    }

    public void setFinancialAccountInformation(String financialAccountInformation) {
        this.financialAccountInformation = financialAccountInformation;
    }

    public boolean getExcludeDeletedIndicator() {
        return excludeDeletedIndicator;
    }

    public void setExcludeDeletedIndicator(boolean excludeDeletedIndicator) {
        this.excludeDeletedIndicator = excludeDeletedIndicator;
    }

    public JmsAuditInfoDto getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(JmsAuditInfoDto auditInfo) {
        this.auditInfo = auditInfo;
    }
}
