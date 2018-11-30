package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * JMS message for getting token info by wallet info.
 *
 * @author v.semerkov
 */
public class GetTokenByWalletIdJmsMessage extends HeadersJmsMessage {
    private JmsGetTokenByWalletIdMessageDto tokenByWalletIdMessageDto;

    public JmsGetTokenByWalletIdMessageDto getTokenByWalletIdMessageDto() {
        return tokenByWalletIdMessageDto;
    }

    public GetTokenByWalletIdJmsMessage tokenByWalletIdMessageDto(JmsGetTokenByWalletIdMessageDto tokenByWalletIdMessageDto) {
        this.tokenByWalletIdMessageDto = tokenByWalletIdMessageDto;
        return this;
    }
}
