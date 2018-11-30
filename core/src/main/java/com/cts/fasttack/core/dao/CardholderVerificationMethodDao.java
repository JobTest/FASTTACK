package com.cts.fasttack.core.dao;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.core.data.CardholderVerificationMethod;

/**
 * @author a.lipavets
 */
public interface CardholderVerificationMethodDao extends GenericDao<Long, CardholderVerificationMethod> {
    /**
     * Return CardholderVerificationMethod by correlationId
     */
    CardholderVerificationMethod getByCorrelationId(String correlationId);

    /**
     * Return CardholderVerificationMethod by tokenRefId, tokenRequestorId
     */
    CardholderVerificationMethod getByTokenRefIdAndRequestorId(String tokenRefId, String tokenRequestorId);
}
