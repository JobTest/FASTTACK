package com.cts.fasttack.mdes.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCurrentFinancialAccountInformationDto;
import com.cts.fasttack.mdes.client.dto.CurrentFinancialAccountInformationDto;

/**
 * @author Dmitry Koval
 */
@Component
public class JmsCurrentFinancialAccountInformationToDtoConverter extends AbstractConverter<JmsCurrentFinancialAccountInformationDto, CurrentFinancialAccountInformationDto> {
    @Override
    protected CurrentFinancialAccountInformationDto generateTarget() {
        return new CurrentFinancialAccountInformationDto();
    }

    @Override
    protected void lightConvert(JmsCurrentFinancialAccountInformationDto source, CurrentFinancialAccountInformationDto target) {
        target.setCountryCode(source.getCountryCode());
        target.setFinancialAccountId(source.getFinancialAccountId());
        target.setInterbankCardAssociationId(source.getInterbankCardAssociationId());
    }
}
