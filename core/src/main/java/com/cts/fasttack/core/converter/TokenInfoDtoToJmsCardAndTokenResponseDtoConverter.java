package com.cts.fasttack.core.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.jms.dto.JmsCardAndTokenResponseDto;

/**
 * {@link TokenInfoDto} to {@link JmsCardAndTokenResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class TokenInfoDtoToJmsCardAndTokenResponseDtoConverter extends AbstractConverter<TokenInfoDto, JmsCardAndTokenResponseDto> {

    @Override
    protected JmsCardAndTokenResponseDto generateTarget() {
        return new JmsCardAndTokenResponseDto();
    }

    @Override
    protected void lightConvert(TokenInfoDto source, JmsCardAndTokenResponseDto target) {
        target.setCardId(source.getPanInternalId());
        target.setCardGUID(source.getPanInternalGuid());
        target.setTokenReferenceId(source.getId().getTokenRefId());
    }
}
