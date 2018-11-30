package com.cts.fasttack.crypto.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.crypto.client.dto.EncryptWithTripleDESCryptoResponseDto;
import com.cts.fasttack.crypto.client.dto.TripleDESEncryptionResultDto;

/**
 * {@link TripleDESEncryptionResultDto} to {@link EncryptWithTripleDESCryptoResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class TripleDESEncryptionResultDtoToResponseDtoConverter extends AbstractConverter<TripleDESEncryptionResultDto, EncryptWithTripleDESCryptoResponseDto> {

    @Override
    protected EncryptWithTripleDESCryptoResponseDto generateTarget() {
        return new EncryptWithTripleDESCryptoResponseDto();
    }

    @Override
    protected void lightConvert(TripleDESEncryptionResultDto source, EncryptWithTripleDESCryptoResponseDto target) {
        target.setEncryptedData(source.getEncryptedData());
        target.setEncryptionKeyIndex(source.getEncryptionKeyIndex());
    }
}
