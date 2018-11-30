package com.cts.fasttack.bank.client.converter;

import java.util.stream.Collectors;

import com.cts.fasttack.bank.client.ws.contragent.SearchContragent2Response;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.jms.dto.JmsSearchContragent2ResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author a.lipavets
 */
@Component
public class SearchContragent2ResponseToDtoConverter extends AbstractConverter<SearchContragent2Response, JmsSearchContragent2ResponseDto> {

    @Override
    protected JmsSearchContragent2ResponseDto generateTarget() {
        return new JmsSearchContragent2ResponseDto();
    }

    @Override
    protected void lightConvert(SearchContragent2Response source, JmsSearchContragent2ResponseDto target) {
        if(!CollectionUtils.isEmpty(source.getContragent())) {
            target.setContragentId(source.getContragent().stream().map(contragent -> contragent.getContragentId().getValue()).collect(Collectors.toList()));
        }
    }
}
