package com.cts.fasttack.jms.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Event for message queue
 *
 * @author Dmitry Koval
 */
@Entity
@Table(name = "JMS_MESSAGE")
@NamedQuery(name = "findAllMessageWithConnector", query = "select m from JmsEventMessage m where m.processorName = :processorName")
public class JmsEventMessage implements Identifiable<Long>, Serializable {

	private static final long serialVersionUID = -4410397596789625687L;

	@Id
    @GenericGenerator(
            name = "JMS_MESSAGE_ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "JMS_MESSAGE_ID_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JMS_MESSAGE_ID_SEQ")
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "MESSAGE_ID")
    private String messageId;

    @Column(name = "PROCESSOR_NAME")
    private String processorName;

    @Column(name = "NUMBER_DELIVERY_ATTEMPTS")
    private int numberOfDeliveryAttempts;

    @Column(name = "MESSAGE_HISTORY_ID")
    private Long messageHistoryId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public int getNumberOfDeliveryAttempts() {
        return numberOfDeliveryAttempts;
    }

    public void setNumberOfDeliveryAttempts(int numberOfDeliveryAttempts) {
        this.numberOfDeliveryAttempts = numberOfDeliveryAttempts;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public Long getMessageHistoryId() {
        return messageHistoryId;
    }

    public void setMessageHistoryId(Long messageHistoryId) {
        this.messageHistoryId = messageHistoryId;
    }
}
