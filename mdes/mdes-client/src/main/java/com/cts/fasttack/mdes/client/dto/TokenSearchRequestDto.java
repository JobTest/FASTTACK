package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Dmitry Koval
 */
@JsonRootName("SearchRequest")
public class TokenSearchRequestDto {

    @JsonProperty("AccountPan")
    private String accountPan;

    @JsonProperty("TokenUniqueReference")
    private String tokenUniqueReference;

    @JsonProperty("Token")
    private String token;

    @JsonProperty("PaymentAppInstanceId")
    private String paymentAppInstanceId;

    @JsonProperty("CommentId")
    private String commentId;

    @JsonProperty("AlternateAccountIdentifier")
    private String alternateAccountIdentifier;

    @JsonProperty("FinancialAccountInformation")
    private String financialAccountInformation;

    @JsonProperty("ExcludeDeletedIndicator")
    private Boolean excludeDeletedIndicator;

    @JsonProperty("AuditInfo")
    private AuditInfoDto auditInfo;

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

    public Boolean getExcludeDeletedIndicator() {
        return excludeDeletedIndicator;
    }

    public void setExcludeDeletedIndicator(Boolean excludeDeletedIndicator) {
        this.excludeDeletedIndicator = excludeDeletedIndicator;
    }

    public AuditInfoDto getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfoDto auditInfo) {
        this.auditInfo = auditInfo;
    }
}
