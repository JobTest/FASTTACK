package com.cts.fasttack.visa.vtis.server.dto;

import com.cts.fasttack.jms.dto.TokenNotificationJmsResponse;

/**
 * @author d.ishchenko
 */
public class TokenNotificationResponseHolder {

    private TokenNotificationJmsResponse response;

	public TokenNotificationJmsResponse getResponse() {
		return response;
	}

	public void setResponse(TokenNotificationJmsResponse response) {
		this.response = response;
	}

}
