package com.cts.fasttack.sms.server.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.sms.server.data.SmsMessageTemplate;

/**
 * @author Anton Leliuk
 */
@Repository
public class SmsMessageTemplateDaoImpl extends GenericDaoImpl<Long, SmsMessageTemplate> implements SmsMessageTemplateDao {


    @Override
    public Class<SmsMessageTemplate> getEntityClass() {
        return SmsMessageTemplate.class;
    }

    @Override
    public SmsMessageTemplate getByType(String type) {
        return (SmsMessageTemplate) getSession()
                .createCriteria(getEntityClass())
                .add(Restrictions.eq("type", type))
                .uniqueResult();
    }

}
