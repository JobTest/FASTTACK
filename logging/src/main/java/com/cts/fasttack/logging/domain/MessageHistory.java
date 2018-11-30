package com.cts.fasttack.logging.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cts.fasttack.common.core.data.Identifiable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Message history
 *
 * @author Dmitry Koval
 */
@Entity
@Table(name = "MSG_HISTORY")
public class MessageHistory implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "MSG_HISTORY_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "MSG_HISTORY_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MSG_HISTORY_ID_SEQ")
    private Long id;


    @Column(name = "PARENT_ID")
    private Long parentId;

    @Column(name = "TOKEN_ID")
    private String tokenId;

    @Column(name = "CONNECTOR_CLIENT")
    private String connectorClient;

    @Column(name = "MSG_TYPE")
    private String msgType;

    @Column(name = "MSG_DATE_IN")
    private Date msgDateIn;

    @Column(name = "MSG_DATE_OUT")
    private Date msgDateOut;

    @Column(name = "MSG_RAW_IN")
    private String msgRawIn;

    @Column(name = "MSG_RAW_OUT")
    private String msgRawOut;

    @Column(name = "DECISION")
    private String decision;

    @Column(name = "ERROR_CODE")
    private String errorCode;

    @Column(name = "CVC_RESP")
    private String cvcResp;

    @Column(name = "MASKED_PAN")
    private String maskedPan;

    @Column(name = "PAN_INTERNAL_ID")
    private String panInternalId;

    @Column(name = "PAN_INTERNAL_GUID")
    private String panInternalGuid;

    @Column(name = "PAN_SOURCE")
    private String panSource;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean isNew() {
        return id == null || id < 1;
    }
}
