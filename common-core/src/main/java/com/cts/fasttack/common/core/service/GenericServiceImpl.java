package com.cts.fasttack.common.core.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.converter.Converter;
import com.cts.fasttack.common.core.dao.GenericDao;
import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.list.QueryResult;

/**
 * @author Anton Leliuk
 */
public abstract class GenericServiceImpl<T extends Serializable, DTO extends IdentifierDto<T>, DOMAIN extends Identifiable<T>, DAO extends GenericDao<T, DOMAIN>> implements GenericService<T, DTO, DOMAIN> {

    protected final Logger log = LogManager.getLogger(getClass());

    protected DAO dao;

    protected Converter<DOMAIN, DTO> domainToDtoConverter;

    protected Converter<DTO, DOMAIN> dtoToDomainConverter;

    public GenericServiceImpl(DAO dao, Converter<DOMAIN, DTO> domainToDtoConverter, Converter<DTO, DOMAIN> dtoToDomainConverter) {
        this.dao = dao;
        this.domainToDtoConverter = domainToDtoConverter;
        this.dtoToDomainConverter = dtoToDomainConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public DTO get(T id) {
        return getOptional(id).orElseThrow((Supplier<BusinessLogicException>) () -> {
            throw new BusinessLogicException(HttpStatus.NOT_FOUND, "Not found entity with id - " + id);
        });
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DTO> getOptional(T id) {
        return Optional.ofNullable(domainToDtoConverter.convert(dao.get(id)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DTO save(DTO item) {
        DOMAIN domain = saveDomain(item);
        return domainToDtoConverter.convert(domain);
    }

    /**
     * Save item without converting to dto after that operation
     */
    protected DOMAIN saveDomain(DTO item) {
        DOMAIN domain = dtoToDomainConverter.convert(item);
        return dao.save(domain);
    }

    @Transactional
    public void delete(DTO item) {
        dao.delete(dtoToDomainConverter.convert(item));
    }

    @Override
    @Transactional
    public void delete(T id) {
        DOMAIN domain = dao.get(id);
        if (domain == null) {
            throw new BusinessLogicException(HttpStatus.NOT_FOUND, "Not found entity with id - " + id);
        }
        dao.delete(domain);
    }

    @Override
    @Transactional
    public DTO update(DTO dto) throws BusinessLogicException {
        return domainToDtoConverter.convert(updateDomain(dto));
    }

    /**
     * Update item without converting to dto after that operation
     */
    protected DOMAIN updateDomain(DTO dto) {
        DOMAIN domain = dao.get(dto.getId());
        if (domain == null) {
            throw new BusinessLogicException(HttpStatus.NOT_FOUND, "Not found entity with id - " + dto.getId());
        }
        dtoToDomainConverter.convertPrimitives(dto, domain);
        return dao.save(domain);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<DTO> listAll() {
        return domainToDtoConverter.convert(dao.list());
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<DTO> list(ListFilter<DOMAIN> filter) {
        List<DOMAIN> list = dao.list(filter);
        List<DTO> dtos = domainToDtoConverter.convert(list);
        return new QueryResult<>(dtos, filter);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExists(T id) {
        return dao.isExists(id);
    }

}
