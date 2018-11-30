package com.cts.fasttack.jms.service;

import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.jms.data.JmsEventMessage;
import com.cts.fasttack.jms.dto.JmsEventMessageDto;

/**
 * Service for jms event message
 *
 * @author Dmitry Koval
 */
public interface JmsEventMessageService extends GenericService<Long, JmsEventMessageDto, JmsEventMessage> {

    /**
     * Save message if not exists
     *
     * @param jmsEventMessage message
     * @return count insert row
     */
    int saveIfNotExists(JmsEventMessage jmsEventMessage);

}
