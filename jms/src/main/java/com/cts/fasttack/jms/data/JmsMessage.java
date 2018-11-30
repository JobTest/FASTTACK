package com.cts.fasttack.jms.data;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Anton Leliuk
 */
public interface JmsMessage {

    /**
     * headers of the jms message
     */
    @JsonIgnore
    Map<String, Object> getHeaders();

    String getOriginator();

    Long getMessageHistoryId();

    void setMessageHistoryId(Long messageHistoryId);
}
