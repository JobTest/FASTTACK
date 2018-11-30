package com.cts.fasttack.sms.server.dto;

import java.util.Date;

import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.sms.server.dict.SmsMessageStatus;


/**
 * @author Anton Leliuk
 */
public class SmsMessageDto extends IdentifierDto<Long> {

    private String messageId;

    private String type;

    private String phone;

    private String text;

    private Date dateCreate;

    private Date dateSend;

    private SmsMessageStatus status = SmsMessageStatus.NEW;

    private String description;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SmsMessageStatus getStatus() {
        return status;
    }

    public void setStatus(SmsMessageStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }
}
