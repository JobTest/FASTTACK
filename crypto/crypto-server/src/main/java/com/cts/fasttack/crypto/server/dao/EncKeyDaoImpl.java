package com.cts.fasttack.crypto.server.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;
import com.cts.fasttack.common.core.util.ObjectUtil;
import com.cts.fasttack.crypto.client.dict.EncKeyStatus;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.data.EncKey;
import com.cts.fasttack.crypto.server.filter.EncKeyListFilter;

@Repository("encKeyDao")
public class EncKeyDaoImpl extends GenericDaoImpl<Long, EncKey> implements EncKeyDao {

    @Override
    public Class<EncKey> getEntityClass() {
        return EncKey.class;
    }

    public EncKey getByKeyTypeAndRefCode(KeyType keyType, String refCode) {
        return (EncKey)getSession().createCriteria(EncKey.class)
                .add(Restrictions.eq("keyType", keyType))
                .add(Restrictions.eq("refCode", refCode))
                .setMaxResults(1)
                .uniqueResult();
    }

    public EncKey getActualKeyByKeyType(KeyType keyType) {
        return (EncKey)getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("keyType", keyType))
                .add(Restrictions.eq("statusCode", EncKeyStatus.ACTIVE))
                .addOrder(Order.desc("expDate"))
                .setMaxResults(1)
                .uniqueResult();
    }

    public List<EncKey> listActiveKeysByType(KeyType keyType){
        Date date = new Date();
        return ObjectUtil.uncheckedCast(getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("keyType", keyType))
                .add(Restrictions.eq("statusCode", EncKeyStatus.ACTIVE))
                .add(Restrictions.and(
                        Restrictions.le("effDate", date),
                        Restrictions.ge("expDate", date)
                )).list());
    }

    public boolean existsByParams(KeyType keyType, String refCode){
        return ((Long)getSession().createCriteria(getEntityClass())
                .setProjection(Projections.count("id"))
                .add(Restrictions.eq("keyType", keyType))
                .add(Restrictions.eq("refCode", refCode))
                .uniqueResult()) > 0L;
    }

    public List<EncKey> list(EncKeyListFilter filter){
        PageCriteria c = PageCriteria.createCriteria(getSession(),getEntityClass());
        if (!StringUtils.isEmpty(filter.getKeyType())) {
            List<KeyType> types = new ArrayList<>();
            Disjunction d = Restrictions.disjunction();

            if(!StringUtils.isEmpty(filter.getRefCode())) {
                d.add(Restrictions.like("refCode", filter.getRefCode(), MatchMode.ANYWHERE));
            }

            if(!StringUtils.isEmpty(filter.getKeyType())) {
                for (KeyType type : KeyType.values()) {
                    if (type.name().contains(filter.getKeyType())) {
                        types.add(type);
                    }
                }
                if (!CollectionUtils.isEmpty(types)) {
                    d.add(Restrictions.in("keyType", types));
                } else{
                    d.add(Restrictions.sqlRestriction("1 = 0"));
                }
            }
            c.add(d);
        }
        return c.list(filter);

    }

}
