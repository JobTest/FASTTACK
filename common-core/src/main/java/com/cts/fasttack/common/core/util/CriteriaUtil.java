package com.cts.fasttack.common.core.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;
import com.cts.fasttack.common.core.data.Identifiable;

/**
 * Класс для создания повторяющихся критерий
 */
public class CriteriaUtil {

    /**
     * Применяет ограничение диапазона [begin,end] для поля fieldName. <p>
     * если begin == null, то поле <= end <p>
     * если end == null, то поле >= begin <p>
     * если begin != null и end != null то поле in [begin,end]
     */
    public static void between(Criteria criteria, String fieldName, Object begin, Object end){
        if(end != null){
            criteria.add(Restrictions.le(fieldName, end));
        }
        if(begin != null){
            criteria.add(Restrictions.ge(fieldName, begin));
        }
    }

    /**
     * Применяет ограничение диапазона [begin,end] для поля fieldName. <p>
     * Приводит begin к 00:00, а end к 24:00
     * если begin == null, то поле <= end <p>
     * если end == null, то поле >= begin <p>
     * если begin != null и end != null то поле in [begin,end]
     */
    public static void dateBetween(Criteria criteria, String fieldName, Date begin, Date end){
        if(end != null){
        	end = new DateTime(end).withTimeAtStartOfDay().plusDays(1).minusMillis(1).toDate();
            criteria.add(Restrictions.le(fieldName, end));
        }
        if(begin != null){
            begin = new DateTime(begin).withTimeAtStartOfDay().toDate();
            criteria.add(Restrictions.ge(fieldName, begin));
        }
    }

    /**
     * Если fieldValue не пусто, то создает ограничение like для поля fieldName
     */
    public static void likeIfNotEmpty(Criteria criteria, String fieldName, String fieldValue){
        if(!StringUtils.isEmpty(fieldValue)){
            criteria.add(Restrictions.like(fieldName, fieldValue.trim(), MatchMode.ANYWHERE));
        }
    }

    /**
     * Если fieldValue != null, то создает ограничение eq для поля fieldName
     */
    public static void eqIfNotEmpty(Criteria criteria, String fieldName, Object fieldValue){
        if(fieldValue != null){
            criteria.add(Restrictions.eq(fieldName, fieldValue));
        }
    }

    /**
     * Создает критерию из списка идентификаторов
     * @param ids список идентификаторов
     * @param clazz entityClass критерии
     * @param restrictions сразу добавляет ограничение для DetachedCriteria
     */
    public static DetachedCriteria fromIdsList(List<?> ids, Class<?> clazz, Criterion... restrictions){
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
        criteria.setProjection(Property.forName("id"));
        criteria.add(Restrictions.in("id", ids));
        if(restrictions != null && restrictions.length > 0){
            for(Criterion criterion : restrictions){
                if(criterion != null){
                    criteria.add(criterion);
                }
            }
        }
        return criteria;
    }

    public static <T extends Serializable> List<T> idsFromIdentifiers(List<? extends Identifiable<T>> list){
        List<T> ids = new ArrayList<>();
        for(Identifiable<T> identifiable : list){
            ids.add(identifiable.getId());
        }
        return ids;
    }

    public static <T extends Serializable> DetachedCriteria fromIdentifiersList(List<? extends Identifiable<T>> list, Class<?> clazz, Criterion... restrictions){
        List<T> ids = idsFromIdentifiers(list);
        return fromIdsList(ids, clazz, restrictions);
    }

}
