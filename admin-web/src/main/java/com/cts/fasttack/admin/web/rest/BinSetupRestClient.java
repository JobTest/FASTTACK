package com.cts.fasttack.admin.web.rest;

import com.cts.fasttack.admin.web.data.dto.BinSetupDto;
import com.cts.fasttack.admin.web.data.list.BinSetupListFilter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.service.ExistCheckService;

/**
 * @author a.lipavets
 */
public interface BinSetupRestClient extends ExistCheckService<String> {

    QueryResultDto<BinSetupDto> filter(BinSetupListFilter filter) throws ServiceException;

    BinSetupDto getBinSetup(Long bin) throws ServiceException;

    void createBinSetup(BinSetupDto binSetupDto) throws ServiceException;

    void updateBinSetup(BinSetupDto binSetupDto) throws ServiceException;

    void deleteBinSetup(String bin) throws ServiceException;
}
