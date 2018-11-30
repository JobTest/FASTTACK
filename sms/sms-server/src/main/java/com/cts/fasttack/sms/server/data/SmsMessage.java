package com.cts.fasttack.sms.server.data;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.sms.server.dict.SmsMessageStatus;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * @author Anton Leliuk
 */
@Table(name = "SMS_MESSAGE")
@Entity
public class SmsMessage implements Identifiable<Long> {

    @Id
    @GenericGenerator(
            name = "SMS_MESSAGE_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "sms_message_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SMS_MESSAGE_ID_SEQ")
    private Long id = -1L;

    @Column(name = "MESSAGE_ID")
    private String messageId;

    @Column(name = "MESSAGE_TYPE")
    private String type;

    @Column
    private String phone;

    @Column(name = "MESSAGE_TEXT")
    private String text;

    @Column(name = "MESSAGE_STATUS")
    @Enumerated(EnumType.STRING)
    private SmsMessageStatus status = SmsMessageStatus.NEW;

    @Column
    private String description;

    @Column(name = "DATE_CREATE")
    private Date dateCreate;

    @Column(name = "DATE_SEND")
    private Date dateSend;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean isNew() {
        return id < 1;
    }
}
