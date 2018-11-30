package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.core.data.CardProduct;
import com.cts.fasttack.core.dto.CardProductDto;
import org.springframework.stereotype.Component;

@Component
public class CardProductDtoToDomainConverter extends AbstractConverter<CardProductDto, CardProduct> {
    @Override
    protected CardProduct generateTarget() {
        return new CardProduct();
    }

    @Override
    protected void lightConvert(CardProductDto source, CardProduct target) {
        target.setId(source.getId());
        target.setProductConfigId(source.getProductConfigId());
        target.setBeginRange(source.getBeginRange());
        target.setEndRange(source.getEndRange());
    }
}
