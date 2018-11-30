package com.cts.fasttack.bank.server.pushprovisioning.converter;

import com.cts.fasttack.bank.server.pushprovisioning.dto.GetTokenByWalletIdResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsGetTokenByWalletIdResponseDto;

/**
 * {@link JmsGetTokenByWalletIdResponseDto} to {@link GetTokenByWalletIdResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class JmsGetTokenByWalletIdResponseDtoToGetTokenByWalletIdResponseDtoConverter extends AbstractConverter<JmsGetTokenByWalletIdResponseDto, GetTokenByWalletIdResponseDto> {

    @Autowired
    private JmsCardAndTokenResponseDtoToCardAndTokenResponseDtoConverter jmsCardAndTokenResponseDtoToCardAndTokenResponseDtoConverter;

    @Override
    protected GetTokenByWalletIdResponseDto generateTarget() {
        return new GetTokenByWalletIdResponseDto();
    }

    @Override
    protected void lightConvert(JmsGetTokenByWalletIdResponseDto source, GetTokenByWalletIdResponseDto target) {
        target.setCardAndToken(jmsCardAndTokenResponseDtoToCardAndTokenResponseDtoConverter.convert(source.getCardAndTokenList()));
    }
}
