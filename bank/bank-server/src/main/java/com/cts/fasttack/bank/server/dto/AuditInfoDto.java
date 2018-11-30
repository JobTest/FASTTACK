package com.cts.fasttack.bank.server.dto;

import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Dto for auditInfo object
 *
 * @author a.lipavets
 */
public class AuditInfoDto {

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 50, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String userId;

    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 500, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
