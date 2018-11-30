package com.cts.fasttack.crypto.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fasttack.common.core.exception.BusinessLogicException;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;
import com.cts.fasttack.crypto.server.converter.EncKeyDtoToDomainConverter;
import com.cts.fasttack.crypto.server.converter.EncKeyDtoToRequestResponseDtoConverter;
import com.cts.fasttack.crypto.server.converter.EncKeyToDtoConverter;
import com.cts.fasttack.crypto.server.dao.EncKeyDao;
import com.cts.fasttack.crypto.server.data.EncKey;
import com.cts.fasttack.crypto.server.data.EncKeyValueHolder;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.dto.EncKeyDto;
import com.cts.fasttack.crypto.server.filter.EncKeyListFilter;

@Service("encKeyService")
public class EncKeyServiceImpl extends GenericServiceImpl<Long, EncKeyDto, EncKey, EncKeyDao> implements EncKeyService {

    private List<KeySupportService> keySupportServices = new ArrayList<>();

    @Autowired
    private EncKeyDtoToRequestResponseDtoConverter encKeyDtoToRequestResponseDtoConverter;

    @Autowired
    public EncKeyServiceImpl(EncKeyDao dao, EncKeyToDtoConverter domainToDtoConverter, EncKeyDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Transactional(rollbackFor = Exception.class)
    public EncKeyDto createNew(EncKeyDto dto) {
        dto.setNew(true);
        return save(dto);
    }

    @Override
    @Transactional(readOnly = true)
    public EncKeyValueHolder getKey(KeyType keyType, String refCode) {
        EncKey key = dao.getByKeyTypeAndRefCode(keyType, refCode);
        if (key != null) {
            return domainToDtoConverter.convert(key);
        }
        return null;
    }

    @Override
    protected EncKey updateDomain(EncKeyDto dto) {
        boolean deleted = false;

        if (!EncKeyService.isActive(dto)) {
            deleted = true;
        }

        EncKey domain = dao.get(dto.getId());
        if (domain == null) {
            throw new BusinessLogicException(HttpStatus.NOT_FOUND, "EncKey with id " + dto.getId() + "not found.");
        }
        dtoToDomainConverter.convert(dto, domain);
        EncKey result = dao.save(domain);
        notifyChangeKey(dto, deleted);
        return result;
    }

    @Override
    @Transactional
    protected EncKey saveDomain(EncKeyDto item) {
        EncKey result = super.saveDomain(item);
        notifyChangeKey(item,false);
        return result;
    }


    @Override
    @Transactional
    public void delete(Long id) {
        EncKey domain = dao.get(id);
        if (domain == null) {
            throw new BusinessLogicException(HttpStatus.NOT_FOUND, "EncKey with id " + id + "not found.");
        }
        EncKeyDto dto = domainToDtoConverter.convert(domain);
        super.delete(id);
        notifyChangeKey(dto,true);
    }


    private void notifyChangeKey(EncKeyDto dto, boolean delete){
        for (KeySupportService kss : keySupportServices) {
            kss.notifyChangeKey(dto, delete);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public EncKeyValueHolder[] listActiveKeysByType(KeyType type) {
        List<EncKey> encKeys = dao.listActiveKeysByType(type);
        EncKeyValueHolder[] result = new EncKeyValueHolder[encKeys.size()];
        for(int i = 0; i< encKeys.size(); i++){
            result[i] = domainToDtoConverter.convert(encKeys.get(i));
        }
        return result;
    }

    @Override
    public void registerKeySupportService(KeySupportService kss) {
        keySupportServices.add(kss);
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<EncKeyRequestResponseDto> listPaged(EncKeyListFilter filter){
        List<EncKey> domains = filter.getKeyType() != null
                ? dao.list(filter).stream()
                    .filter(encKey -> encKey.getKeyType().getKey().toLowerCase().equals(filter.getKeyType().toLowerCase()))
                    .collect(Collectors.toList())
                : dao.list(filter);

        List<EncKeyDto> dtos = domainToDtoConverter.convert(domains);
        return new QueryResult<>(encKeyDtoToRequestResponseDtoConverter.convert(dtos),filter);
    }

    /**
     * Проверяет существование ключа с заданным keyType и refCode
     * */

    @Override
    @Transactional(readOnly = true)
    public boolean existsByParams(KeyType keyType, String refCode){
        return dao.existsByParams(keyType, refCode);
    }

    @Override
    @Transactional(readOnly = true)
    public EncKeyValueHolder getActualKey(KeyType keyType) {
        return domainToDtoConverter.convert(dao.getActualKeyByKeyType(keyType));
    }
}
