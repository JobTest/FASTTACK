package com.cts.fasttack.bank.client.converter;

import com.cts.fasttack.bank.client.ws.contragent.ObjectFactory;
import com.cts.fasttack.bank.client.ws.contragent.SearchContragent2;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsSearchContragent2Dto;
import org.springframework.stereotype.Component;

/**
 * @author a.lipavets
 */
@Component
public class JmsSearchContragent2DtoToWsDtoConverter extends AbstractConverter<JmsSearchContragent2Dto, SearchContragent2> {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @Override
    protected SearchContragent2 generateTarget() {
        return OBJECT_FACTORY.createSearchContragent2();
    }

    @Override
    protected void lightConvert(JmsSearchContragent2Dto request, SearchContragent2 wsRequest) {
        wsRequest.setContragentCategory(request.getContragentCategory());
        wsRequest.setContragentId(request.getContragentId());
        wsRequest.setDocNo(request.getDocNo());
        wsRequest.setDocSr(request.getDocSr());
        wsRequest.setName(request.getName());
        wsRequest.setSName(request.getsName());
        wsRequest.setTaxId(request.getTaxId());
    }
}
