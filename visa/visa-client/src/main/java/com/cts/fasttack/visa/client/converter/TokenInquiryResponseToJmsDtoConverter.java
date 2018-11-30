package com.cts.fasttack.visa.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenInquiryResponseDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class TokenInquiryResponseToJmsDtoConverter extends AbstractConverter<TokenInquiryResponseDto, JmsTokenInquiryResponseDto> {

    @Autowired
    private TokenDetailsToJmsDtoConverter tokenDatailsToJmsDtoConverter;

    @Override
    protected JmsTokenInquiryResponseDto generateTarget() {
        return new JmsTokenInquiryResponseDto();
    }

    @Override
    protected void lightConvert(TokenInquiryResponseDto source, JmsTokenInquiryResponseDto target) {
        target.setActionCode(source.getActionCode());
        target.setErrorCode(source.getErrorCode());
        target.setTokenDetails(tokenDatailsToJmsDtoConverter.convert(source.getTokenDetails()));
    }
}
