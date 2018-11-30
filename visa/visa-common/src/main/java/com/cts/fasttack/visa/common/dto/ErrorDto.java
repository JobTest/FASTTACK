package com.cts.fasttack.visa.common.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Information about error
 * @author Anton Leliuk
 */
public class ErrorDto {

    private int status;
    private String message;
    private String reason;

    private List<ErrorDetailsDto> details;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                .append("status", status)
                .append("message", message)
                .append("reason", reason)
                .append("details", details)
                .toString();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ErrorDetailsDto> getDetails() {
        return details;
    }

    public void setDetails(List<ErrorDetailsDto> details) {
        this.details = details;
    }
}
