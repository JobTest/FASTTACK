package com.cts.fasttack.core.service;

import java.util.List;
import java.util.Map;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.service.GenericService;
import com.cts.fasttack.core.data.FEProp;
import com.cts.fasttack.core.dto.FEPropDto;

/**
 * Interface for actions with bank setting parameters data.
 *
 * @author v.semerkov
 */
public interface FEPropService extends GenericService<String, FEPropDto, FEProp> {

    String PROPERTY_MERCHANT_ID = "MERCHANT_ID";
    String PROPERTY_TERMINAL_ID = "TERMINAL_ID";
    String PROPERTY_CALL_CENTER_AUTOMATED_NUMBER = "CALL_CENTER_AUTOMATED_NUMBER";
    String PROPERTY_ORG_NAME = "ORG_NAME";

    FEPropDto createFEProp(FEPropDto dto) throws ServiceException;

    FEPropDto updateFEProp(FEPropDto dto) throws ServiceException;

    /**
     * Returns property map by property name list.
     *
     * @param propNameList property name list
     * @return property map
     */
    Map<String, String> getPropertyMapByNameList(List<String> propNameList);
}
