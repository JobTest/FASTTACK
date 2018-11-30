package com.cts.fasttack.logging.domain.filter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.logging.domain.MessageHistory;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Message history list filter.
 *
 * @author v.semerkov
 */
public class MessageHistoryListFilter extends ListFilter<MessageHistory> {

    private String connectorClient;

    private String msgType;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date msgDateInFrom;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date msgDateInTill;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date msgDateOutFrom;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date msgDateOutTill;

    private String maskedPan;

    private String panInternalId;

    private String panInternalGuid;

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

    public Date getMsgDateInFrom() {
        return msgDateInFrom;
    }

    public void setMsgDateInFrom(Date msgDateInFrom) {
        this.msgDateInFrom = msgDateInFrom;
    }

    public Date getMsgDateInTill() {
        return msgDateInTill;
    }

    public void setMsgDateInTill(Date msgDateInTill) {
        this.msgDateInTill = msgDateInTill;
    }

    public Date getMsgDateOutFrom() {
        return msgDateOutFrom;
    }

    public void setMsgDateOutFrom(Date msgDateOutFrom) {
        this.msgDateOutFrom = msgDateOutFrom;
    }

    public Date getMsgDateOutTill() {
        return msgDateOutTill;
    }

    public void setMsgDateOutTill(Date msgDateOutTill) {
        this.msgDateOutTill = msgDateOutTill;
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
