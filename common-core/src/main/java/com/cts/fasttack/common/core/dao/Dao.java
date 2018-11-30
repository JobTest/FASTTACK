package com.cts.fasttack.common.core.dao;

import org.hibernate.Session;

/**
 * @author Anton Leliuk
 */
public interface Dao {

    Session getSession();

    void flushSession();

    void clearSession();

}
