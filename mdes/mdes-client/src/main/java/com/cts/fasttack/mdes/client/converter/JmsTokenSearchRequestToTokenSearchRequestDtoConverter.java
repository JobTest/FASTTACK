package com.cts.fasttack.mdes.client.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenSearchRequestDto;
import com.cts.fasttack.mdes.client.dto.TokenSearchRequestDto;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsTokenSearchRequestToTokenSearchRequestDtoConverter extends AbstractConverter<JmsTokenSearchRequestDto, TokenSearchRequestDto> {

    @Autowired
    private JmsAuditInfoToAuditInfoDtoConverter jmsAuditInfoToAuditInfoDtoConverter;

    @Override
    protected TokenSearchRequestDto generateTarget() {
        return new TokenSearchRequestDto();
    }

    @Override
    protected void lightConvert(JmsTokenSearchRequestDto source, TokenSearchRequestDto target) {
        target.setAccountPan(source.getAccountPan());
        target.setTokenUniqueReference(source.getTokenUniqueReference());
        target.setToken(source.getToken());
        target.setPaymentAppInstanceId(source.getPaymentAppInstanceId());
        target.setCommentId(source.getCommentId());
        target.setAlternateAccountIdentifier(source.getAlternateAccountIdentifier());
        target.setFinancialAccountInformation(source.getFinancialAccountInformation());
        target.setExcludeDeletedIndicator(source.getExcludeDeletedIndicator());
        target.setAuditInfo(jmsAuditInfoToAuditInfoDtoConverter.convert(source.getAuditInfo()));
    }
}
