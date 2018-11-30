package com.cts.fasttack.jms.data;

/**
 * Persist JMS message with body
 *
 * @author Dmitry Koval
 */
public class PersistJmsMessage extends HeadersJmsMessage {

    private JmsEventMessage body;

    public PersistJmsMessage body(JmsEventMessage body){
        this.body = body;
        return this;
    }

    public JmsEventMessage getBody() {
        return body;
    }

}
