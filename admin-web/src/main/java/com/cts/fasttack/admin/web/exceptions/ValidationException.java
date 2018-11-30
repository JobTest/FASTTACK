package com.cts.fasttack.admin.web.exceptions;

import java.util.Map;

/**
 * Simple validation exception
 *
 * @author Anton Leliuk
 */
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 7399602643076049073L;

	/**
     * Standard message exception
     */
    private final static String STANDARD_MESSAGE = "During system operation errors occurred!";

    /**
     * Map with identificators and error messages
     */
    private Map<String, String> messageMap;

    public ValidationException(Map<String, String> messageMap) {
        super(STANDARD_MESSAGE);
        this.messageMap = messageMap;
    }

    public Map<String, String> getMessageMap() {
        return messageMap;
    }

    public void setMessageMap(Map<String, String> messageMap) {
        this.messageMap = messageMap;
    }
}
