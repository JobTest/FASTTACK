package com.cts.fasttack.jms.dao;

import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.jms.data.JmsEventMessage;

@Repository("messageDao")
public class JmsEventMessageDaoImpl extends GenericDaoImpl<Long, JmsEventMessage> implements JmsEventMessageDao {
    @Override
    public Class<JmsEventMessage> getEntityClass() {
        return JmsEventMessage.class;
    }

    @Override
    public int saveIfNotExists(JmsEventMessage jmsEventMessage) {
        return getSession()
                .createSQLQuery("INSERT INTO JMS_MESSAGE (CONTENT, MESSAGE_ID, PROCESSOR_NAME, NUMBER_DELIVERY_ATTEMPTS, MESSAGE_HISTORY_ID) SELECT :content, :messageId, :processorName, :numberOfDeliveryAttempts, :messageHistoryId WHERE NOT EXISTS (SELECT id FROM JMS_MESSAGE WHERE MESSAGE_ID = :messageId AND PROCESSOR_NAME=:processorName)")
                .setParameter("content", jmsEventMessage.getContent())
                .setParameter("messageId", jmsEventMessage.getMessageId())
                .setParameter("processorName", jmsEventMessage.getProcessorName())
                .setParameter("messageHistoryId", jmsEventMessage.getMessageHistoryId())
                .setParameter("numberOfDeliveryAttempts", jmsEventMessage.getNumberOfDeliveryAttempts())
                .executeUpdate();
    }

}
