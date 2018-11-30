package com.cts.fasttack.core.service;

import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.TokenRequestorDtoToDomainConverter;
import com.cts.fasttack.core.converter.TokenRequestorToDtoConverter;
import com.cts.fasttack.core.dao.TokenRequestorDao;
import com.cts.fasttack.core.data.TokenRequestor;
import com.cts.fasttack.core.dto.TokenRequestorDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tokenRequestorService")
public class TokenRequestorServiceImpl extends GenericServiceImpl<String, TokenRequestorDto, TokenRequestor, TokenRequestorDao> implements TokenRequestorService {

    private Logger logger = LogManager.getLogger(TokenRequestorServiceImpl.class);

    @Autowired
    public TokenRequestorServiceImpl(TokenRequestorDao dao, TokenRequestorToDtoConverter domainToDtoConverter, TokenRequestorDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }
}
