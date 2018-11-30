package com.cts.fasttack.core.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.util.ObjectUtil;
import com.cts.fasttack.core.data.FEProp;

/**
 * Class for access to bank setting parameters data.
 *
 * @author v.semerkov
 */
@Repository("fePropDao")
public class FEPropDaoImpl extends GenericDaoImpl<String, FEProp> implements FEPropDao {

    @Override
    public Class<FEProp> getEntityClass() {
        return FEProp.class;
    }

    @Override
    public Map<String, String> getPropertyMapByNameList(List<String> propNameList) {
        List<FEProp> fePropList = ObjectUtil.uncheckedCast(getSession().createCriteria(getEntityClass())
                .add(Restrictions.in("propName", propNameList))
                .list());

        return fePropList.stream().collect(Collectors.toMap(FEProp::getPropName, FEProp::getPropValue));
    }
}
