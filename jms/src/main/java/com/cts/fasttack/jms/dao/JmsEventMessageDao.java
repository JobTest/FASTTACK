package com.cts.fasttack.jms.dao;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.jms.data.JmsEventMessage;

/**
 * Dao for queue message
 *
 * @author Dmitry Koval
 */
public interface JmsEventMessageDao extends GenericDao<Long, JmsEventMessage> {

    /**
     * Save message if not exists
     *
     * @param jmsEventMessage message
     * @return count insert row
     */
    int saveIfNotExists(JmsEventMessage jmsEventMessage);

}
