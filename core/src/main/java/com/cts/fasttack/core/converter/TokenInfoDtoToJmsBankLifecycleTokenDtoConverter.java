package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.dto.TokenInfoDto;
import com.cts.fasttack.jms.dto.JmsBankLifecycleTokenDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * {@link TokenInfoDto} to {@link JmsBankLifecycleTokenDto} converter.
 */
@Component
public class TokenInfoDtoToJmsBankLifecycleTokenDtoConverter extends AbstractConverter<TokenInfoDto, JmsBankLifecycleTokenDto> {

    @Override
    protected JmsBankLifecycleTokenDto generateTarget() {
        return new JmsBankLifecycleTokenDto();
    }

    @Override
    protected void lightConvert(TokenInfoDto source, JmsBankLifecycleTokenDto target) {
        target.setTokenRefId(source.getId().getTokenRefId());
        target.setTokenRequestorId(source.getId().getTokenRequestorId());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGUID(source.getPanInternalGuid());
        target.setIps(source.getIps().name());
        target.setRequestId(UUID.randomUUID().toString());
    }
}
