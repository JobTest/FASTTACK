package com.cts.fasttack.sms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.sms.server.converter.SmsMessageDtoToDomainConverter;
import com.cts.fasttack.sms.server.converter.SmsMessageToDtoConverter;
import com.cts.fasttack.sms.server.dao.SmsMessageDao;
import com.cts.fasttack.sms.server.data.SmsMessage;
import com.cts.fasttack.sms.server.dict.SmsMessageStatus;
import com.cts.fasttack.sms.server.dto.SmsMessageDto;

/**
 * @author Anton Leliuk
 */
@Service
public class SmsMessageServiceImpl extends GenericServiceImpl<Long, SmsMessageDto, SmsMessage, SmsMessageDao> implements SmsMessageService {

    @Autowired
    public SmsMessageServiceImpl(SmsMessageDao dao, SmsMessageToDtoConverter domainToDtoConverter, SmsMessageDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Transactional
    @Override
    public int updateStatus(String messageId, SmsMessageStatus status) {
        return dao.updateStatus(messageId, status);
    }
}
