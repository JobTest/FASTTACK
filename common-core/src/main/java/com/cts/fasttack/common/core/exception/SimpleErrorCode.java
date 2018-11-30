package com.cts.fasttack.common.core.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Обертка для строкового представления кода ошибки
 */
public class SimpleErrorCode implements ErrorCode {

    private String name;

    @JsonCreator
    public SimpleErrorCode(@JsonProperty("name") String name) {
        this.name = name;
    }

    @JsonIgnore
    public String name() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SimpleErrorCode [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
		}
		builder.append("]");
		return builder.toString();
	}
    
}
