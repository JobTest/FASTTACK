package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class TokenCreateNotificationJmsMessage extends HeadersJmsMessage {

    private JmsTokenCreateNotificationDto jmsTokenCreateNotificationDto;

    private Boolean cardTokenized;
    
    private String panInternalId;
    
    private String panInternalGuid;

    public JmsTokenCreateNotificationDto getJmsTokenCreateNotificationDto() {
        return jmsTokenCreateNotificationDto;
    }

    public TokenCreateNotificationJmsMessage jmsTokenCreateNotificationDto(JmsTokenCreateNotificationDto jmsTokenCreateNotificationDto) {
        this.jmsTokenCreateNotificationDto = jmsTokenCreateNotificationDto;
        return this;
    }

    public Boolean isCardTokenized() {
        return cardTokenized;
    }

    public void setCardTokenized(Boolean cardTokenized) {
        this.cardTokenized = cardTokenized;
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
