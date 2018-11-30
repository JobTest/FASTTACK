package com.cts.fasttack.admin.web.converter;

import com.cts.fasttack.admin.web.data.domain.CardProduct;
import com.cts.fasttack.admin.web.data.dto.CardProductDto;
import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
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
        target.setBeginRange(source.getBeginRange().toString());
        target.setEndRange(source.getEndRange().toString());
    }
}
