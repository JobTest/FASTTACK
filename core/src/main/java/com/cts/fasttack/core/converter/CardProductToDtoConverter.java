package com.cts.fasttack.core.converter;

import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.core.data.CardProduct;
import com.cts.fasttack.core.dto.CardProductDto;
import org.springframework.stereotype.Component;

@Component
public class CardProductToDtoConverter extends IdentifierToDtoConverter<String, CardProduct, CardProductDto> {
    @Override
    protected CardProductDto generateTarget() {
        return new CardProductDto();
    }

    @Override
    public void convert(CardProduct source, CardProductDto target) {
        target.setProductConfigId(source.getProductConfigId());
        target.setBeginRange(source.getBeginRange());
        target.setEndRange(source.getEndRange());
    }
}
