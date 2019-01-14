package com.cts.fasttack.visa.client.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenInquiryDto;
import com.cts.fasttack.visa.client.dto.TokenInquiryRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class TokenInquiryJmsToRequestDtoConverter extends AbstractConverter<JmsTokenInquiryDto, TokenInquiryRequestDto> {

    @Autowired
    private JmsCardholderInfoToDtoConverter jmsCardholderInfoToDtoConverter;

    @Override
    protected TokenInquiryRequestDto generateTarget() {
        return new TokenInquiryRequestDto();
    }

    @Override
    protected void lightConvert(JmsTokenInquiryDto source, TokenInquiryRequestDto target) {
        if (source.getCardholderInfo() != null) {
            target.setCardholderInfo(jmsCardholderInfoToDtoConverter.convert(source.getCardholderInfo()));
        }
        target.setOperatorID(source.getOperatorID());
        target.setPanReferenceID(source.getPanReferenceID());
        target.setRequestID(source.getRequestID());
        target.setToken(source.getToken());
        target.setTokenReferenceID(source.getTokenReferenceID());
        target.setTokenRequestorID(source.getTokenRequestorID());
    }
}
