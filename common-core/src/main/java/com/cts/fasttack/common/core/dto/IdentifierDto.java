package com.cts.fasttack.common.core.dto;

import com.cts.fasttack.common.core.data.Identifiable;

import java.io.Serializable;

/**
 * @author Anton Leliuk
 */
public class IdentifierDto<T extends Serializable> implements Identifiable<T> {

    private T id;

    public IdentifierDto() {}

    public IdentifierDto(T id) {
        this.id = id;
    }

    @Override
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return id != null;
    }
}
