package com.cts.fasttack.bank.server.dto;

import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author a.lipavets
 */
public class CommonTokenLifecycleRequestDto {
    /**
     * Unique request identifier
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 36, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
