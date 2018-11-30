package com.cts.fasttack.sms.server.dao;


import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.sms.server.data.SmsMessageTemplate;

/**
 * @author Anton Leliuk
 */
public interface SmsMessageTemplateDao extends GenericDao<Long, SmsMessageTemplate> {

    SmsMessageTemplate getByType(String type);
}
