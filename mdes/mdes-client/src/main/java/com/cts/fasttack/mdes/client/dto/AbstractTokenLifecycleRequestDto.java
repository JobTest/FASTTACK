package com.cts.fasttack.mdes.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tokenUniqueReference",
        "commentText",
        "reasonCode",
        "accountPan",
        "paymentAppInstanceId",
        "auditInfo"
})
public abstract class AbstractTokenLifecycleRequestDto {

    @JsonProperty("TokenUniqueReference")
    @XmlElement(name = "TokenUniqueReference")
    private String tokenUniqueReference;

    @JsonProperty("CommentText")
    @XmlElement(name = "CommentText")
    private String commentText;

    @JsonProperty("ReasonCode")
    @XmlElement(name = "ReasonCode")
    private String reasonCode;

    @XmlElement(name = "AccountPan")
    @JsonProperty("AccountPan")
    private String accountPan;

    @JsonProperty("PaymentAppInstanceId")
    @XmlElement(name = "PaymentAppInstanceId")
    private String paymentAppInstanceId;

    @JsonProperty("AuditInfo")
    @XmlElement(name = "AuditInfo")
    private AuditInfoDto auditInfo;

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

    public AuditInfoDto getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfoDto auditInfo) {
        this.auditInfo = auditInfo;
    }

    public String getAccountPan() {
        return accountPan;
    }

    public void setAccountPan(String accountPan) {
        this.accountPan = accountPan;
    }

    public String getPaymentAppInstanceId() {
        return paymentAppInstanceId;
    }

    public void setPaymentAppInstanceId(String paymentAppInstanceId) {
        this.paymentAppInstanceId = paymentAppInstanceId;
    }
}
