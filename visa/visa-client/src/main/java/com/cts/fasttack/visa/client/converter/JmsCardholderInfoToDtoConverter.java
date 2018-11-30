package com.cts.fasttack.visa.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardholderInformationDto;
import com.cts.fasttack.visa.client.dto.CardholderInfoDto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class JmsCardholderInfoToDtoConverter extends AbstractConverter<JmsCardholderInformationDto, CardholderInfoDto> {
    @Override
    protected CardholderInfoDto generateTarget() {
        return new CardholderInfoDto();
    }

    @Override
    protected void lightConvert(JmsCardholderInformationDto source, CardholderInfoDto target) {
        target.setVersion(source.getVersion());
        target.setEncryptedData(source.getEncryptedData());
        target.setEncryptionKeyIndex(source.getEncryptionKeyIndex());
    }
}
