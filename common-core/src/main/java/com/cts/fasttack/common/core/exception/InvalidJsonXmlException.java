package com.cts.fasttack.common.core.exception;

/**
 * Exception marker that we have a problem with parsing JSON/XML
 * @author Anton Leliuk
 */
public class InvalidJsonXmlException extends RuntimeException {

	private static final long serialVersionUID = -2954552172003953669L;

	public InvalidJsonXmlException(Throwable cause) {
        super(cause);
    }
}
