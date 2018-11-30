package com.cts.fasttack.bank.server.pushprovisioning.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;

/**
 * Request DTO for getting token by wallet identifier.
 *
 * @author v.semerkov
 */
@XmlRootElement(name = "GetTokenByWalletIdRequest")
public class GetTokenByWalletIdRequestDto {

    /**
     * Request identifier
     */
    @Size(min = 1, max = 30, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String requestID;

    /**
     * Wallet on device account identifier
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(min = 1, max = 48, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String clientWalletAccountId;

    /**
     * Customer identifier of the digital wallet provider.
     * Identifier is the initiator ID of the token request (TRID),
     * which is issued to the wallet provider within the onboarding process.
     * Example value: "40000000047"
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 50, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    @Pattern(regexp = "[0-9A-Za-z-_]*", message = StandardErrorCodes.Names.INVALID_FIELD_VALUE)
    private String clientWalletProvider;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getClientWalletAccountId() {
        return clientWalletAccountId;
    }

    public void setClientWalletAccountId(String clientWalletAccountId) {
        this.clientWalletAccountId = clientWalletAccountId;
    }

    public String getClientWalletProvider() {
        return clientWalletProvider;
    }

    public void setClientWalletProvider(String clientWalletProvider) {
        this.clientWalletProvider = clientWalletProvider;
    }
}
