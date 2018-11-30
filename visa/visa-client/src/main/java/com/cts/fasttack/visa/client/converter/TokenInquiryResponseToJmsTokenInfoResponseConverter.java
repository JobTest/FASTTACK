package com.cts.fasttack.visa.client.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenInfoResponseDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryResponseDto;

/**
 * {@link TokenInquiryResponseDto} to {@link JmsTokenInfoResponseDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class TokenInquiryResponseToJmsTokenInfoResponseConverter extends AbstractConverter<TokenInquiryResponseDto, JmsTokenInfoResponseDto> {

    @Autowired
    private TokenDetailsDtoToJmsTokenResponseDtoConverter tokenDetailsDtoToJmsTokenResponseDtoConverter;

    @Override
    protected JmsTokenInfoResponseDto generateTarget() {
        return new JmsTokenInfoResponseDto();
    }

    @Override
    protected void lightConvert(TokenInquiryResponseDto source, JmsTokenInfoResponseDto target) {
        target.setActionCode(source.getActionCode());
        target.setErrorCode(source.getErrorCode());
        target.setTokens(tokenDetailsDtoToJmsTokenResponseDtoConverter.convert(source.getTokenDetails()));
    }
}
