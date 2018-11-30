package com.cts.fasttack.mdes.client.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsTokenUpdateMdesDto;
import com.cts.fasttack.mdes.client.dto.TokenUpdateRequestDto;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsTokenUpdateMdesToRequestDtoConverter extends AbstractConverter<JmsTokenUpdateMdesDto, TokenUpdateRequestDto>{

    @Autowired
    private JmsCurrentFinancialAccountInformationToDtoConverter jmsCurrentFinancialAccountInformationToDtoConverter;

    @Autowired
    private JmsAuditInfoToAuditInfoDtoConverter jmsAuditInfoToAuditInfoDtoConverter;

    @Override
    protected TokenUpdateRequestDto generateTarget() {
        return new TokenUpdateRequestDto();
    }

    @Override
    protected void lightConvert(JmsTokenUpdateMdesDto source, TokenUpdateRequestDto target) {
        target.setNewAccountPan(source.getNewAccountPan());
        target.setCurrentFinancialAccountInformation(jmsCurrentFinancialAccountInformationToDtoConverter.convert(source.getCurrentFinancialAccountInformation()));
        target.setNewFinancialAccountId(source.getNewFinancialAccountId());
        target.setExpirationDate(source.getExpirationDate());
        target.setAccountPanSequenceNumber(source.getAccountPanSequenceNumber());
        target.setIssuerProductConfigurationId(source.getIssuerProductConfigurationId());
        target.setUpdateWalletProviderIndicator(source.getUpdateWalletProviderIndicator());
        target.setTokenUniqueReference(source.getTokenUniqueReference());
        target.setCommentText(source.getCommentText());
        target.setReasonCode(source.getReasonCode());
        target.setAuditInfo(jmsAuditInfoToAuditInfoDtoConverter.convert(source.getAuditInfo()));
    }
}
