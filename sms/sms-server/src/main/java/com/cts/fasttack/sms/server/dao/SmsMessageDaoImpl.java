package com.cts.fasttack.sms.server.dao;


import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.sms.server.data.SmsMessage;
import com.cts.fasttack.sms.server.dict.SmsMessageStatus;

/**
 * @author Anton Leliuk
 */
@Repository
public class SmsMessageDaoImpl extends GenericDaoImpl<Long, SmsMessage> implements SmsMessageDao {

    @Override
    public Class<SmsMessage> getEntityClass() {
        return SmsMessage.class;
    }

    @Override
    public int updateStatus(String messageId, SmsMessageStatus status) {
        return getSession().createQuery("UPDATE SmsMessage SET status = :status WHERE messageId = :messageId")
                .setParameter("status", status)
                .setParameter("messageId", messageId)
                .executeUpdate();
    }


}
