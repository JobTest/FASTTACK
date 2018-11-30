package com.cts.fasttack.sms.server.dict;

/**
 * @author Anton Leliuk
 */
public enum SmsMessageStatus {

    NEW,
    SENDING,
    RECEIVED,
    ERROR;

    public boolean isError(){
        return this == ERROR;
    }
}
