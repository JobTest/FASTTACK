package com.cts.fasttack.visa.vtis.server.converter;

import com.cts.fasttack.visa.vtis.server.dto.VisaEncryptedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsVisaEncryptedDataDto;

/**
 * @author Dmitry Koval
 */
@Component
public class VisaEncryptedDataToJmsDtoConverter extends AbstractConverter<VisaEncryptedData, JmsVisaEncryptedDataDto> {

    @Autowired
    private TokenNotificationCardHolderInfoToJmsDtoConverter tokenNotificationCardHolderInfoToJmsDtoConverter;

    @Autowired
    private TokenInfoToJmsConverter tokenInfoToJmsConverter;


    @Override
    protected JmsVisaEncryptedDataDto generateTarget() {
        return new JmsVisaEncryptedDataDto();
    }

    @Override
    protected void lightConvert(VisaEncryptedData source, JmsVisaEncryptedDataDto target) {
        target.setCardholderInfo(tokenNotificationCardHolderInfoToJmsDtoConverter.convert(source.getCardholderInfo()));
        target.setTokenInfo(tokenInfoToJmsConverter.convert(source.getTokenInfo()));
    }
}
