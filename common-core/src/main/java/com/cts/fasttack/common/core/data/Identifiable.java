package com.cts.fasttack.common.core.data;

import java.io.Serializable;

/**
 * @author Anton Leliuk
 */
public interface Identifiable<T extends Serializable> {

    T getId();

    boolean isNew();

}
