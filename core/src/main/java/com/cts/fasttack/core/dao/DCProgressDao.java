package com.cts.fasttack.core.dao;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.core.data.DCProgress;

/**
 * Dao for {@link DCProgress}
 *
 * @author Dmitry Koval
 */
public interface DCProgressDao extends GenericDao<Long, DCProgress> {

    void deleteExpireAndFinishedDCProgress(Integer expireDays);

    DCProgress get(String requestId, String correlationId, String tokenRequestorId);

    DCProgress get(String correlationId);

    boolean tryLock(long id);
}
