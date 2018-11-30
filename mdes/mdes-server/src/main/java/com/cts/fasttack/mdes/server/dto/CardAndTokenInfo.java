package com.cts.fasttack.mdes.server.dto;

import javax.validation.constraints.Size;

import com.cts.fasttack.common.core.exception.StandardErrorCodes;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains card and token information of the card to be digitized
 *
 * @author a.lipavets
 */
public class CardAndTokenInfo extends CardInfo {
    /**
     * Globally unique identifier for the token, as assigned by MDES
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenUniqueReference;

    /** getters and setters */

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }
}
