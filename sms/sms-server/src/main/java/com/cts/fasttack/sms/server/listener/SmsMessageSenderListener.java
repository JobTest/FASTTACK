package com.cts.fasttack.sms.server.listener;


import com.cts.fasttack.sms.server.dto.SmsMessageDto;

/**
 * @author Anton Leliuk
 */
public interface SmsMessageSenderListener {

    void onMessageSuccessSend(SmsMessageDto smsMessageDto);

    public class NoOpSmsMessageSenderListener implements SmsMessageSenderListener {

        public static final NoOpSmsMessageSenderListener INSTANCE = new NoOpSmsMessageSenderListener();

        @Override
        public void onMessageSuccessSend(SmsMessageDto smsMessageDto) {}
    }
}
