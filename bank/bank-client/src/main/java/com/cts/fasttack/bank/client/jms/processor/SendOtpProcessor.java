package com.cts.fasttack.bank.client.jms.processor;

import com.cts.fasttack.bank.client.ws.service.SendOtpWebService;
import com.cts.fasttack.jms.dto.SendOtpJmsMessage;
import com.cts.fasttack.jms.dto.BankJmsResponseDto;
import com.cts.fasttack.jms.processor.AbstractCamelProcessor;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class SendOtpProcessor extends AbstractCamelProcessor<SendOtpJmsMessage, BankJmsResponseDto> {

    @Autowired
    private SendOtpWebService sendOtpWebService;

    @Override
    public void process(Exchange exchange) throws Exception {
        execute(exchange, SendOtpJmsMessage.class, request -> sendOtpWebService.sendOtp(request.getSendOtpDto()));
    }
}
