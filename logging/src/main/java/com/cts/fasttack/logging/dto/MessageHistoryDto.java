package com.cts.fasttack.logging.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.logging.domain.MessageHistory;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * DTO for {@link MessageHistory}
 *
 * @author Dmitry Koval
 */
public class MessageHistoryDto extends IdentifierDto<Long> {

    private Long parentId;

    private String tokenId;

    private String connectorClient;

    private String msgType;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date msgDateIn;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date msgDateOut;

    private String msgRawIn;

    private String msgRawOut;

    private String decision;

    private String errorCode;

    private String cvcResp;

    private String maskedPan;

    private String panInternalId;

    private String panInternalGuid;

    private String panSource;

    public MessageHistoryDto() {}

    public MessageHistoryDto(Long id) {
        super(id);
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getConnectorClient() {
        return connectorClient;
    }

    public void setConnectorClient(String connectorClient) {
        this.connectorClient = connectorClient;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Date getMsgDateIn() {
        return msgDateIn;
    }

    public void setMsgDateIn(Date msgDateIn) {
        this.msgDateIn = msgDateIn;
    }

    public Date getMsgDateOut() {
        return msgDateOut;
    }

    public void setMsgDateOut(Date msgDateOut) {
        this.msgDateOut = msgDateOut;
    }

    public String getMsgRawIn() {
        return msgRawIn;
    }

    public void setMsgRawIn(String msgRawIn) {
        this.msgRawIn = msgRawIn;
    }

    public String getMsgRawOut() {
        return msgRawOut;
    }

    public void setMsgRawOut(String msgRawOut) {
        this.msgRawOut = msgRawOut;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getCvcResp() {
        return cvcResp;
    }

    public void setCvcResp(String cvcResp) {
        this.cvcResp = cvcResp;
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

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }
}
