package com.cts.fasttack.mdes.client.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;
import com.cts.fasttack.jms.dto.TokenSearchAccountDto;

/**
 * {@link TokenSearchAccountDto} to {@link List}&lt;{@link JmsTokenResponseDto}&gt; converter.
 *
 * @author v.semerkov
 */
@Component
public class TokenSearchAccountDtoToJmsTokenResponseDtoConverter extends AbstractConverter<TokenSearchAccountDto, List<JmsTokenResponseDto>> {

    @Autowired
    private TokenSearchAccountTokenDtoToJmsTokenResponseDtoConverter tokenSearchAccountTokenDtoToJmsTokenResponseDtoConverter;

    @Override
    protected List<JmsTokenResponseDto> generateTarget() {
        return new ArrayList<>();
    }

    @Override
    protected void lightConvert(TokenSearchAccountDto source, List<JmsTokenResponseDto> target) {
        if (source.getToken() != null && !CollectionUtils.isEmpty(source.getToken().getTokens())) {
            target.addAll( tokenSearchAccountTokenDtoToJmsTokenResponseDtoConverter.convert(source.getToken().getTokens()) );

            target.forEach(token -> {
                token.setAccountPanSuffix(source.getAccountPanSuffix());
                token.setPanExpirationDate(source.getExpirationDate());
            });
        }
    }
}
