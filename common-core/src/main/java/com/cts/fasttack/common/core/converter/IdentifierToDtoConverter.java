package com.cts.fasttack.common.core.converter;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.dto.IdentifierDto;

import java.io.Serializable;

/**
 * @author Anton Leliuk
 */
public abstract class IdentifierToDtoConverter<T extends Serializable, I extends Identifiable<T>, DTO extends IdentifierDto<T>> extends AbstractConverter<I, DTO> {

    @Override
    protected void lightConvert(I source, DTO target) {
        target.setId(source.getId());
    }

}
