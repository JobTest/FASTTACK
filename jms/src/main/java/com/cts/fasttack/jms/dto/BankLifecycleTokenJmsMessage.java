package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * JMS message for token activate
 * .
 * @author a.lipavets
 */
public class BankLifecycleTokenJmsMessage extends HeadersJmsMessage{
    private JmsBankLifecycleTokenDto bankLifecycleTokenDto;

    public JmsBankLifecycleTokenDto getBankLifecycleTokenDto() {
        return bankLifecycleTokenDto;
    }

    public BankLifecycleTokenJmsMessage activateTokenDto(JmsBankLifecycleTokenDto bankLifecycleTokenDto) {
        this.bankLifecycleTokenDto = bankLifecycleTokenDto;
        return this;
    }

}
