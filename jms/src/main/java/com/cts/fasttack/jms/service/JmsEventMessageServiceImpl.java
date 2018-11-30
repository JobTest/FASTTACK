package com.cts.fasttack.jms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.jms.converter.JmsEventMessageDtoToDomainConverter;
import com.cts.fasttack.jms.converter.JmsEventMessageToDtoConverter;
import com.cts.fasttack.jms.dao.JmsEventMessageDao;
import com.cts.fasttack.jms.data.JmsEventMessage;
import com.cts.fasttack.jms.dto.JmsEventMessageDto;

/**
 * @author Dmitry Koval
 */
@Service("jmsMessageService")
public class JmsEventMessageServiceImpl extends GenericServiceImpl<Long, JmsEventMessageDto, JmsEventMessage, JmsEventMessageDao> implements JmsEventMessageService {

    @Autowired
    public JmsEventMessageServiceImpl(JmsEventMessageDao dao, JmsEventMessageToDtoConverter domainToDtoConverter, JmsEventMessageDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional
    public int saveIfNotExists(JmsEventMessage jmsEventMessage) {
        return dao.saveIfNotExists(jmsEventMessage);
    }

}
