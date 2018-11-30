package com.cts.fasttack.core.dao;

import java.util.List;

import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.core.data.BinSetup;
import com.cts.fasttack.core.data.list.BinSetupListFilter;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

@Repository
public class BinSetupDaoImpl extends GenericDaoImpl<Long, BinSetup> implements BinSetupDao {

    @Override
    public Class<BinSetup> getEntityClass() {
        return BinSetup.class;
    }

    @Override
    public BinSetup getSuitableBin(String bin) {
        return (BinSetup) getSession().createCriteria(getEntityClass())
                .add(Restrictions.sqlRestriction("? LIKE CONCAT({alias}.BIN, '%')", new Object[]{bin}, new Type[]{StandardBasicTypes.STRING}))
                .addOrder(Order.desc("bin"))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public List<BinSetup> list(ListFilter<BinSetup> filter) {
        PageCriteria pageCriteria = createPageCriteria(getEntityClass());
        if(((BinSetupListFilter)filter).getBin() != null) {
            pageCriteria.add(Restrictions.sqlRestriction("? LIKE CONCAT({alias}.BIN, '%')", new Object[]{((BinSetupListFilter)filter).getBin().toString()}, new Type[]{StandardBasicTypes.STRING}));
        }
        return pageCriteria.list(filter);
    }
}
