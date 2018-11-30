package com.cts.fasttack.jms.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple JMS message with headers
 * @author Anton Leliuk
 */
public class HeadersJmsMessage implements JmsMessage {

    private String originator;

    private Long messageHistoryId;

    private Map<String, Object> headers = new HashMap<>();

    public HeadersJmsMessage header(String key, Object value){
        this.headers.put(key, value);
        return this;
    }

    public HeadersJmsMessage originator(String originator){
        this.originator = originator;
        return this;
    }

    public HeadersJmsMessage messageHistoryId(Long messageHistoryId){
        this.messageHistoryId = messageHistoryId;
        return this;
    }

    public Object getHeader(String key){
        return this.headers.get(key);
    }

    @Override
    public Map<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    @Override
    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    @Override
    public Long getMessageHistoryId() {
        return messageHistoryId;
    }

    @Override
    public void setMessageHistoryId(Long messageHistoryId) {
        this.messageHistoryId = messageHistoryId;
    }
}
