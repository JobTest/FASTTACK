package com.cts.fasttack.sms.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.sms.client.dto.SmsRestRequestDto;
import com.cts.fasttack.sms.server.service.SmsMessageServiceClient;

/**
 * @author Dmitry Koval
 */

@RestController
@RequestMapping("/sms/client")
public class SmsRestController {


    @Autowired
    private SmsMessageServiceClient smsMessageServiceClient;


    @PostMapping("/send")
    public void send(@RequestBody SmsRestRequestDto requestDto) throws ServiceException {
        smsMessageServiceClient.send(requestDto.getType(), requestDto.getPhone(), requestDto.getTemplateParameters());
    }

}
