package com.cts.fasttack.common.core.rest.jwt.service;

import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * @author Anton Leliuk
 */
public interface JwtService {

    /**
     * Generate signature
     * @param originator {@link String} initial request originator
     * @param ttl {@link Long} time-to-live of signature in seconds
     * @return {@link String} signature
     */
    String sign(String originator, long ttl) throws ServiceException;

    /**
     * Verify signature
     * @param signature {@link String} original signature
     * @return {@link Boolean} true if signature verified and not expired
     */
    boolean verify(String signature) throws ServiceException;
}
