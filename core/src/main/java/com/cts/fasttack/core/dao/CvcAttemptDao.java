package com.cts.fasttack.core.dao;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.core.data.CvcAttempt;

/**
 * @author d.koval
 */
public interface CvcAttemptDao extends GenericDao<Long, CvcAttempt> {

    CvcAttempt getByPanInternalIdAndGUID(String panInternalID, String panInternalGUID);

}
