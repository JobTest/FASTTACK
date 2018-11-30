package com.cts.fasttack.core.dao;

import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.core.data.CardProduct;
import com.cts.fasttack.core.data.list.CardProductListFilter;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

@Repository("cardProductDao")
public class CardProductDaoImpl extends GenericDaoImpl<String, CardProduct> implements CardProductDao {

    @Override
    public Class<CardProduct> getEntityClass() {
        return CardProduct.class;
    }

    @Override
    public List<CardProduct> list(ListFilter<CardProduct> filter) {
        PageCriteria pageCriteria = createPageCriteria(getEntityClass());
        if(((CardProductListFilter)filter).getProductConfigId() != null) {
            pageCriteria.add(Restrictions.sqlRestriction("? LIKE CONCAT({alias}.PRODUCT_CONFIG_ID, '%')", new Object[]{((CardProductListFilter)filter).getProductConfigId().toString()}, new Type[]{StandardBasicTypes.STRING}));
        }
        return pageCriteria.list(filter);
    }

    @Override
    public List<CardProduct> listCardProduct(CardProductListFilter filter) {
        PageCriteria pageCriteria = createPageCriteria(getEntityClass());
        if (StringUtils.isNotBlank(filter.getProductConfigId())) {
            pageCriteria.add(Restrictions.disjunction()
                    .add(Restrictions.ilike("id", filter.getProductConfigId(), MatchMode.ANYWHERE)));
//                    .add(Restrictions.ilike("beginRange", Long.valueOf(filter.getProductConfigId()).toString(), MatchMode.ANYWHERE))); //todo the number can't use like (use like only String)
        }
        return pageCriteria.list(filter);
    }
}
