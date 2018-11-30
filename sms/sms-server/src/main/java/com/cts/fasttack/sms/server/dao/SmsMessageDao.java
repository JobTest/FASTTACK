package com.cts.fasttack.sms.server.dao;


import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.sms.server.data.SmsMessage;
import com.cts.fasttack.sms.server.dict.SmsMessageStatus;

/**
 * @author Anton Leliuk
 */
public interface SmsMessageDao extends GenericDao<Long, SmsMessage> {

    int updateStatus(String messageId, SmsMessageStatus status);
}
