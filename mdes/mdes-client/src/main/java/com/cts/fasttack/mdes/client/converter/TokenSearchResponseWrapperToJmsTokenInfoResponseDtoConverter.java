package com.cts.fasttack.mdes.client.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.jms.dto.JmsTokenResponseDto;
import com.cts.fasttack.jms.dto.TokenSearchResponseWrapper;

/**
 * {@link TokenSearchResponseWrapper} to {@link JmsTokenInfoResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class TokenSearchResponseWrapperToJmsTokenInfoResponseDtoConverter extends AbstractConverter<TokenSearchResponseWrapper, JmsTokenInfoResponseDto> {

    @Autowired
    private TokenSearchAccountDtoToJmsTokenResponseDtoConverter tokenSearchAccountDtoToJmsTokenResponseDtoConverter;

    @Override
    protected JmsTokenInfoResponseDto generateTarget() {
        return new JmsTokenInfoResponseDto();
    }

    @Override
    protected void lightConvert(TokenSearchResponseWrapper source, JmsTokenInfoResponseDto target) {
        target.setTokens(new ArrayList<>());

        Optional.ofNullable(source.getResponseDto())
                .ifPresent(responseDto -> Optional.ofNullable(responseDto.getAccount())
                        .ifPresent(tokenSearchAccountsDto -> {
                            if (!CollectionUtils.isEmpty(tokenSearchAccountsDto.getAccounts())) {
                                tokenSearchAccountsDto.getAccounts().forEach(account -> {
                                    List<JmsTokenResponseDto> tokens = tokenSearchAccountDtoToJmsTokenResponseDtoConverter.convert(account);

                                    if (!CollectionUtils.isEmpty(tokens)) {
                                        target.getTokens().addAll(tokens);
                                    }
                                });
                            }
                        }));
    }
}
