package com.cts.fasttack.jms.dto;

import com.cts.fasttack.jms.data.HeadersJmsMessage;

/**
 * @author Dmitry Koval
 */
public class ConfirmProvisioningJmsMessage extends HeadersJmsMessage {

    private JmsConfirmProvisioningDto jmsConfirmProvisioningDto;

    public JmsConfirmProvisioningDto getJmsConfirmProvisioningDto() {
        return jmsConfirmProvisioningDto;
    }

    public ConfirmProvisioningJmsMessage confirmProvisioningDto(JmsConfirmProvisioningDto jmsConfirmProvisioningDto) {
        this.jmsConfirmProvisioningDto = jmsConfirmProvisioningDto;
        return this;
    }
}
