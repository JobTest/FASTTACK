package com.cts.fasttack.admin.web.dao.impl;

import com.cts.fasttack.admin.web.dao.CardProductDao;
import com.cts.fasttack.admin.web.data.domain.CardProduct;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("cardProductDao")
public class CardProductDaoImpl extends GenericDaoImpl<String, CardProduct> implements CardProductDao {

    @Override
    public Class<CardProduct> getEntityClass() {
        return CardProduct.class;
    }

}
