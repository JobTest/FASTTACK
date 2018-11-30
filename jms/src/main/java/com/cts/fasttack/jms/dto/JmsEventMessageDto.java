package com.cts.fasttack.jms.dto;

import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.jms.data.JmsEventMessage;

/**
 * DTO для {@link JmsEventMessage}
 *
 * @author Dmitry Koval
 */
public class JmsEventMessageDto extends IdentifierDto<Long> {

    private String content;

    private String messageId;

    private String processorName;

    private int numberOfDeliveryAttempts;

    private Long messageHistoryId;

    public JmsEventMessageDto() {
    }

    public JmsEventMessageDto(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
