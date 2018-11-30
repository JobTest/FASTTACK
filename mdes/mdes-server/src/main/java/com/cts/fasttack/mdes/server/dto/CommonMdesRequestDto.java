package com.cts.fasttack.mdes.server.dto;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;

/**
 * @author a.lipavets
 */
public abstract class CommonMdesRequestDto {

    /**
     * The id of the request submitted
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
