package com.cts.fasttack.core.dao;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.core.data.CardProduct;
import com.cts.fasttack.core.data.list.CardProductListFilter;

import java.util.List;

public interface CardProductDao extends GenericDao<Long, CardProduct> {

    List<CardProduct> listCardProduct(CardProductListFilter filter);

}
