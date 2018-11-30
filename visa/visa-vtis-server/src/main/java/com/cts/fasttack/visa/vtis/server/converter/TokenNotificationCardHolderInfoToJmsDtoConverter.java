package com.cts.fasttack.visa.vtis.server.converter;

import com.cts.fasttack.visa.vtis.server.dto.TokenNotificationCardHolderInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsCardholderInfoDto;

/**
 * @author Dmitry Koval
 */
@Component
public class TokenNotificationCardHolderInfoToJmsDtoConverter extends AbstractConverter<TokenNotificationCardHolderInfoDto, JmsCardholderInfoDto> {

    @Autowired
    private ExpirationDateToJmsDtoConverter expirationDateToJmsDtoConverter;

    @Override
    protected JmsCardholderInfoDto generateTarget() {
        return new JmsCardholderInfoDto();
    }

    @Override
    protected void lightConvert(TokenNotificationCardHolderInfoDto source, JmsCardholderInfoDto target) {
        target.setPrimaryAccountNumber(source.getPrimaryAccountNumber());
        target.setName(source.getName());
        target.setCvv2(source.getCvv2());
        target.setExpirationDate(expirationDateToJmsDtoConverter.convert(source.getExpirationDate()));
    }
}
