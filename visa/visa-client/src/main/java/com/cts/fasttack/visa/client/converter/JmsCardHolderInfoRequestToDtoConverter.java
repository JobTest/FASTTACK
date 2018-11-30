package com.cts.fasttack.visa.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardHolderInfoRequestDto;
import com.cts.fasttack.visa.client.dto.CardholderInfoRequestDto;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsCardHolderInfoRequestToDtoConverter extends AbstractConverter<JmsCardHolderInfoRequestDto, CardholderInfoRequestDto> {
    @Override
    protected CardholderInfoRequestDto generateTarget() {
        return new CardholderInfoRequestDto();
    }

    @Override
    protected void lightConvert(JmsCardHolderInfoRequestDto source, CardholderInfoRequestDto target) {
        target.setVersion(source.getVersion());
        target.setEncryptedData(source.getEncryptedData());
        target.setEncryptionKeyIndex(source.getEncryptionKeyIndex());
    }
}
