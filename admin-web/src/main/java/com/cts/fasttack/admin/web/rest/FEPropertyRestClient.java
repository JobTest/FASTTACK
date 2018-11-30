package com.cts.fasttack.admin.web.rest;

import com.cts.fasttack.admin.web.data.dto.FEPropDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.ExistCheckService;

public interface FEPropertyRestClient extends ExistCheckService<String> {

    /**
     * Get query result of FEProp by filter
     */
    QueryResult<FEPropDto> filterFEProperty(ListFilter<?> request) throws ServiceException;

    /**
     * Get FEProp by name
     */
    FEPropDto getFEProp(String propName) throws ServiceException;

    /**
     * Create FRProp
     */
    void createFEProp(FEPropDto feProp) throws ServiceException;

    /**
     * Update FRProp
     */
    void updateFEProp(FEPropDto feProp) throws ServiceException;

    /**
     * Delete FRProp
     */
    void deleteFEProp(String propName) throws ServiceException;

}
