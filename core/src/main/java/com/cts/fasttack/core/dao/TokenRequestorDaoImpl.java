package com.cts.fasttack.core.dao;

import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.core.data.TokenRequestor;
import org.springframework.stereotype.Repository;

@Repository("tokenRequestorDao")
public class TokenRequestorDaoImpl extends GenericDaoImpl<String, TokenRequestor> implements TokenRequestorDao {
    @Override
    public Class<TokenRequestor> getEntityClass() {
        return TokenRequestor.class;
    }
}
