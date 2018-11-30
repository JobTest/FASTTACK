package com.cts.fasttack.crypto.server.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;
import com.cts.fasttack.crypto.client.dict.EncKeyCapacityType;
import com.cts.fasttack.crypto.client.dict.EncKeyStatus;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.server.dto.EncKeyDto;

/**
 * @author Dmitry Koval
 */
@Component
public class EncKeyRequestResponseDtoToDtoConverter extends AbstractConverter<EncKeyRequestResponseDto, EncKeyDto> {
    @Override
    protected EncKeyDto generateTarget() {
        return new EncKeyDto();
    }

    @Override
    protected void lightConvert(EncKeyRequestResponseDto source, EncKeyDto target) {
        target.setId(source.getId());
        target.setKeyType(KeyType.valueOf(source.getKeyType()));
        target.setRefCode(source.getRefCode());
        target.setCapacity(EncKeyCapacityType.valueOf(source.getCapacity()));
        target.setStatusCode(EncKeyStatus.valueOf(source.getStatusCode()));
        target.setKeyValue(source.getKeyValue());
        target.setCheckValue(source.getCheckValue());
        target.setPublicExponent(source.getPublicExponent());
        target.setEffDate(source.getEffDate());
        target.setExpDate(source.getExpDate());
        target.setWrappingKey(source.getWrappingKey());
        target.setNew(source.isNew());
    }
}
