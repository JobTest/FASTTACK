package com.cts.fasttack.sms.server.service;


import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.sms.server.data.SmsMessage;
import com.cts.fasttack.sms.server.dict.SmsMessageStatus;
import com.cts.fasttack.sms.server.dto.SmsMessageDto;

/**
 * @author Anton Leliuk
 */
public interface SmsMessageService extends GenericService<Long, SmsMessageDto, SmsMessage> {

    int updateStatus(String messageId, SmsMessageStatus status);
}
