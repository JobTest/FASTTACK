package com.cts.fasttack.admin.web.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.admin.web.converter.AccessLogDtoToDomainConverter;
import com.cts.fasttack.admin.web.converter.AccessLogToDtoConverter;
import com.cts.fasttack.admin.web.dao.AccessLogDao;
import com.cts.fasttack.admin.web.data.domain.AccessLog;
import com.cts.fasttack.admin.web.data.dto.AccessLogDto;
import com.cts.fasttack.admin.web.data.filter.AccessLogFilter;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.common.core.list.QueryResult;

@Service
public class AccessLogServiceImpl implements AccessLogService {

    @Autowired
    private AccessLogToDtoConverter domainToDtoConverter;

    @Autowired
    private AccessLogDtoToDomainConverter dtoToDomainConverter;

    @Autowired
    private AccessLogDao dao;

    @Autowired
    private AccessLogService accessLogService;

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public AccessLogDto save(AccessLogDto item) {
        AccessLog domain = dtoToDomainConverter.convert(item);
        domain.setAccessDate(new Date());
        domain.setUsername(userService.getCurrentUser().getName());
        return domainToDtoConverter.convert(dao.save(domain));
    }

    @Transactional(readOnly = true)
    @Override
    public QueryResult<AccessLogDto> listPaged(AccessLogFilter filter){
        return new QueryResult<>(domainToDtoConverter.convert(dao.listAll(filter)), filter);
    }

    @Override
    public Builder create() {
        return new Builder(accessLogService);
    }

    public void setDomainToDtoConverter(AccessLogToDtoConverter domainToDtoConverter) {
        this.domainToDtoConverter = domainToDtoConverter;
    }

    public void setDtoToDomainConverter(AccessLogDtoToDomainConverter dtoToDomainConverter) {
        this.dtoToDomainConverter = dtoToDomainConverter;
    }

    public void setDao(AccessLogDao dao) {
        this.dao = dao;
    }
}
