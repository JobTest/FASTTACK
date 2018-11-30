package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.client.cardPT.GetCustomerID;
import com.cts.fasttack.bank.client.ws.client.cardPT.ObjectFactory;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsGetCustomerIDMessageDto;
import org.springframework.stereotype.Component;

/**
 * {@link JmsGetCustomerIDMessageDto} to {@link GetCustomerID} converter.
 *
 * @author v.semerkov
 */
@Component
public class JmsGetCustomerIDMessageDtoToGetCustomerIDConverter extends AbstractConverter<JmsGetCustomerIDMessageDto, GetCustomerID> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Override
    protected GetCustomerID generateTarget() {
        return OBJECT_FACTORY.createGetCustomerID();
    }

    @Override
    protected void lightConvert(JmsGetCustomerIDMessageDto source, GetCustomerID target) {
        target.setCardID(source.getCardID());
        target.setCardGUID(source.getCardGUID());
        target.setCardNum(source.getCardNum());
        target.setHashNum(source.getHashNum());
    }
}
