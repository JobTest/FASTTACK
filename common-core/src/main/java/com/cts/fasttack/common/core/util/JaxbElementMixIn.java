package com.cts.fasttack.common.core.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anton Leliuk
 */
public interface JaxbElementMixIn {

    @JsonIgnore
    boolean isTypeSubstituted();

    @JsonIgnore
    boolean isGlobalScope();

    @JsonIgnore
    boolean isNil();

    @JsonIgnore
    Class<?> getScope();

    @JsonIgnore
    Class<?> getDeclaredType();

    @JsonProperty
    Object getValue();

}
