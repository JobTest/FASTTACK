package com.cts.fasttack.admin.web.converter;

import com.cts.fasttack.admin.web.data.domain.CardProduct;
import com.cts.fasttack.admin.web.data.dto.CardProductDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class CardProductDtoToDomainConverter extends AbstractConverter<CardProductDto, CardProduct> {
    @Override
    protected CardProduct generateTarget() {
        return new CardProduct();
    }

    @Override
    protected void lightConvert(CardProductDto source, CardProduct target) {
        target.setProductConfigId(source.getProductConfigId());
        target.setBeginRange(Long.valueOf(source.getBeginRange()));
        target.setEndRange(Long.valueOf(source.getEndRange()));
    }
}
