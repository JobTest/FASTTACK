package com.cts.fasttack.crypto.server.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.crypto.server.data.EncKey;
import com.cts.fasttack.crypto.server.dto.EncKeyDto;
import org.springframework.stereotype.Component;

@Component
public class EncKeyDtoToDomainConverter extends AbstractConverter<EncKeyDto, EncKey> {

    @Override
    protected EncKey generateTarget() {
        return new EncKey();
    }

    @Override
    public void convertPrimitives(EncKeyDto source, EncKey target) {
        target.setId(source.getId());
        target.setKeyType(source.getKeyType());
        target.setRefCode(source.getRefCode());
    }

    @Override
    protected void lightConvert(EncKeyDto source, EncKey target) {
        target.setId(source.getId() == null ? -1L : source.getId());
        target.setKeyType(source.getKeyType());
        target.setRefCode(source.getRefCode());
        target.setCapacity(source.getCapacity());
        target.setStatusCode(source.getStatusCode());
        target.setKeyValue(source.getKeyValue());
        target.setCheckValue(source.getCheckValue());
        target.setEffDate(source.getEffDate());
        target.setExpDate(source.getExpDate());
        target.setPublicExponent(source.getPublicExponent());
        target.setWrappingKey(source.getWrappingKey());
    }
}
