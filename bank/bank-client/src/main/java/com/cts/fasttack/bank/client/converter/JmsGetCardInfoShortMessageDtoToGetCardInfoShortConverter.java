package com.cts.fasttack.bank.client.converter;

import org.springframework.stereotype.Component;
import com.cts.fasttack.bank.client.ws.client.cardPT.GetCardInfoShort;
import com.cts.fasttack.bank.client.ws.client.cardPT.ObjectFactory;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsGetCardInfoShortMessageDto;

/**
 * {@link JmsGetCardInfoShortMessageDto} to {@link GetCardInfoShort} converter.
 *
 * @author v.semerkov
 */
@Component
public class JmsGetCardInfoShortMessageDtoToGetCardInfoShortConverter extends AbstractConverter<JmsGetCardInfoShortMessageDto, GetCardInfoShort> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Override
    protected GetCardInfoShort generateTarget() {
        return OBJECT_FACTORY.createGetCardInfoShort();
    }

    @Override
    protected void lightConvert(JmsGetCardInfoShortMessageDto source, GetCardInfoShort target) {
        target.setPan(source.getPan());
    }
}
