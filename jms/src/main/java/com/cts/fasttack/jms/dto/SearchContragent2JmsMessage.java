package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author a.lipavets
 */
public class SearchContragent2JmsMessage extends HeadersJmsMessage {
    private JmsSearchContragent2Dto searchContragent2Dto;

    public JmsSearchContragent2Dto getSearchContragent2Dto() {
        return searchContragent2Dto;
    }

    public SearchContragent2JmsMessage searchContragent2Dto(JmsSearchContragent2Dto searchContragent2Dto) {
        this.searchContragent2Dto = searchContragent2Dto;
        return this;
    }
}
