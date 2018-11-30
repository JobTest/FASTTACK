package com.cts.fasttack.logging.dao;

import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.logging.dao.AlertLogDao;
import com.cts.fasttack.logging.domain.AlertLog;

/**
 * @author Dmitry Koval
 */
@Repository("alertLogDao")
public class AlertLogDaoImpl extends GenericDaoImpl<Long, AlertLog> implements AlertLogDao {
    @Override
    public Class<AlertLog> getEntityClass() {
        return AlertLog.class;
    }
}
