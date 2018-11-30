package com.cts.fasttack.core.dao;

import java.util.List;
import java.util.Map;

import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.core.data.FEProp;

/**
 * Interface for access to bank setting parameters data.
 *
 * @author v.semerkov
 */
public interface FEPropDao extends GenericDao<String, FEProp> {

    /**
     * Returns property map by property name list.
     *
     * @param propNameList property name list
     * @return property map
     */
    Map<String, String> getPropertyMapByNameList(List<String> propNameList);
}
