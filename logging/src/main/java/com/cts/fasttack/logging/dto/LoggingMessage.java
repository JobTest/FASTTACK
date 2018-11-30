package com.cts.fasttack.logging.dto;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Anton Leliuk
 */
public class LoggingMessage {

    public static final String ID_KEY = LoggingMessage.class.getName() + ".ID";
    private static final String NEW_LINE_SEPARATOR = System.lineSeparator();
    private static final AtomicInteger ID = new AtomicInteger();
    public static final String REQUEST_MESSAGE = "Request Message" + NEW_LINE_SEPARATOR + "----------------------------";
    public static final String RESPONSE_MESSAGE = "Response Message" + NEW_LINE_SEPARATOR + "---------------------------";

    private final String heading;
    private final StringBuilder address;
    private final StringBuilder contentType;
    private final StringBuilder encoding;
    private final StringBuilder httpMethod;
    private final StringBuilder header;
    private final StringBuilder message;
    private StringBuilder payload;
    private final StringBuilder responseCode;
    private final StringBuilder remoteAddress;
    private final String id;

    public LoggingMessage(String i) {
        this(null, i);
    }

    public LoggingMessage(String h, String i) {
        heading = h;
        id = i;

        contentType = new StringBuilder();
        address = new StringBuilder();
        encoding = new StringBuilder();
        httpMethod = new StringBuilder();
        header = new StringBuilder();
        message = new StringBuilder();
        payload = new StringBuilder();
        responseCode = new StringBuilder();
        remoteAddress = new StringBuilder();
    }

    public String getId() {
        return id;
    }

    public static String nextId() {
        return Integer.toString(ID.incrementAndGet());
    }

    public LoggingMessage address(String address) {
        this.address.append(address);
        return this;
    }

    public LoggingMessage encoding(String encoding) {
        this.encoding.append(encoding);
        return this;
    }

    public LoggingMessage header(Object header) {
        this.header.append(header);
        return this;
    }

    public LoggingMessage httpMethod(String method) {
        this.httpMethod.append(method);
        return this;
    }

    public LoggingMessage contentType(String contentType) {
        this.contentType.append(contentType);
        return this;
    }

    public LoggingMessage message(CharSequence message) {
        this.message.append(message);
        return this;
    }

    public LoggingMessage payload(CharSequence payload) {
        this.payload.append(payload);
        return this;
    }

    public LoggingMessage resetPayload(CharSequence payload) {
        this.payload = new StringBuilder(StringUtils.defaultIfBlank(payload, ""));
        return this;
    }

    public LoggingMessage responseCode(int responseCode) {
        this.responseCode.append(responseCode);
        return this;
    }

    public LoggingMessage remoteAddress(String remoteAddress) {
        this.remoteAddress.append(remoteAddress);
        return this;
    }

    public StringBuilder getPayload() {
        return payload;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();

        if (heading != null) {
            buffer.append(heading);
            buffer.append(NEW_LINE_SEPARATOR);
        }

        buffer.append("ID: ").append(id);

        if (remoteAddress.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Remote-Address: ");
            buffer.append(remoteAddress);
        }
        if (address.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Address: ");
            buffer.append(address);
        }
        if (responseCode.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Response-Code: ");
            buffer.append(responseCode);
        }
        if (encoding.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Encoding: ");
            buffer.append(encoding);
        }
        if (httpMethod.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Http-Method: ");
            buffer.append(httpMethod);
        }
        if (contentType.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Content-Type: ");
            buffer.append(contentType);
        }
        if (header.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Headers: ");
            buffer.append(header);
        }
        if (message.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Messages: ");
            buffer.append(message);
        }
        if (payload.length() > 0) {
            buffer.append(NEW_LINE_SEPARATOR).append("Payload: ");
            buffer.append(payload);
        }
        if (heading != null) {
            // footer separation needs only when we have heading
            buffer.append(NEW_LINE_SEPARATOR).append("--------------------------------------");
        }
        return buffer.toString();
    }
}
