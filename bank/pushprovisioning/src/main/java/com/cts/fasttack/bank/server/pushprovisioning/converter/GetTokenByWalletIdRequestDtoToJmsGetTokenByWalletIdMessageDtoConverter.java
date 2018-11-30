package com.cts.fasttack.bank.server.pushprovisioning.converter;

import com.cts.fasttack.bank.server.pushprovisioning.dto.GetTokenByWalletIdRequestDto;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsGetTokenByWalletIdMessageDto;

/**
 * {@link GetTokenByWalletIdRequestDto} to {@link JmsGetTokenByWalletIdMessageDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class GetTokenByWalletIdRequestDtoToJmsGetTokenByWalletIdMessageDtoConverter extends AbstractConverter<GetTokenByWalletIdRequestDto, JmsGetTokenByWalletIdMessageDto> {

    @Override
    protected JmsGetTokenByWalletIdMessageDto generateTarget() {
        return new JmsGetTokenByWalletIdMessageDto();
    }

    @Override
    protected void lightConvert(GetTokenByWalletIdRequestDto source, JmsGetTokenByWalletIdMessageDto target) {
        target.setClientWalletAccountId(source.getClientWalletAccountId());
        target.setClientWalletProvider(source.getClientWalletProvider());
    }
}
