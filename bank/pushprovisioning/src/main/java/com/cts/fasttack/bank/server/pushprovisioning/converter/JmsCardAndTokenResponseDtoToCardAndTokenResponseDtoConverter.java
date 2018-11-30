package com.cts.fasttack.bank.server.pushprovisioning.converter;

import com.cts.fasttack.bank.server.pushprovisioning.dto.CardAndTokenResponseDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardAndTokenResponseDto;

/**
 * {@link JmsCardAndTokenResponseDto} to {@link CardAndTokenResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class JmsCardAndTokenResponseDtoToCardAndTokenResponseDtoConverter extends AbstractConverter<JmsCardAndTokenResponseDto, CardAndTokenResponseDto> {

    @Override
    protected CardAndTokenResponseDto generateTarget() {
        return new CardAndTokenResponseDto();
    }

    @Override
    protected void lightConvert(JmsCardAndTokenResponseDto source, CardAndTokenResponseDto target) {
        target.setCardId(StringUtils.trimToNull(source.getCardId()));
        target.setCardGUID(StringUtils.trimToNull(source.getCardGUID()));
        target.setTokenReferenceId(source.getTokenReferenceId());
    }
}
