package com.cts.fasttack.mdes.server.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import com.cts.fasttack.mdes.server.dict.SuspendedBy;
import com.cts.fasttack.mdes.server.validation.ValidEnumArray;

/**
 * Object that contains the Tokens which were updated.
 *
 * @author a.lipavets
 */
public class TokenDto {
    /**
     * The unique reference allocated to the token in the Digitize response
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenUniqueReference;

    /**
     * The current status of token
     */
    @Size(max = 32, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String status;

    /**
     * Who or what caused the token to be suspended
     */
    @Valid
    @ValidEnumArray(enumType = SuspendedBy.class, message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private List<String> suspendedBy;

    /**
     * The expiry of the Token PAN given in MMYY format
     */
    @Size(max = 4, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "^(0[1-9]|1[0-2])[0-9][0-9]$|^$",  message = StandardErrorCodes.Names.INVALID_FIELD_FORMAT)
    private String tokenExpiry;

    /* getters and setters */

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSuspendedBy() {
        return suspendedBy;
    }

    public void setSuspendedBy(List<String> suspendedBy) {
        this.suspendedBy = suspendedBy;
    }

    public String getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(String tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }
}
