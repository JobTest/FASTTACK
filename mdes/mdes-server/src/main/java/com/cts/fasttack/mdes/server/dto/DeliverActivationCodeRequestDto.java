package com.cts.fasttack.mdes.server.dto;

import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import com.cts.fasttack.common.core.exception.StandardErrorCodes;

/**
 * DeliverActivationCode request for sending PassCode in the body of SMS
 *
 * @author a.lipavets
 */
@XmlRootElement(name = "request")
public class DeliverActivationCodeRequestDto extends CommonMdesRequestDto {

    /**
     * Unique reference to the token to be designated when digitization is complete.
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 64, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String tokenUniqueReference;

    /**
     * Value linking pre-digitization messages generated during provisioning.
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 14, message = StandardErrorCodes.Names.INVALID_FIELD_LENGTH)
    private String correlationId;

    /**
     * The Activation Code to be distributed for the digitization
     */
    @NotEmpty(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Size(max = 32, message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private String activationCode;

    /**
     * The DateTime when the Activation Code is no longer valid
     */
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    private Date expirationDateTime;

    /**
     * The activation method selected by the Cardholder
     */
    @NotNull(message = StandardErrorCodes.Names.MISSING_REQUIRED_FIELD)
    @Valid
    private ActivationMethod activationMethod;

    /** getters and setters */

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public void setTokenUniqueReference(String tokenUniqueReference) {
        this.tokenUniqueReference = tokenUniqueReference;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Date getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(Date expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

    public ActivationMethod getActivationMethod() {
        return activationMethod;
    }

    public void setActivationMethod(ActivationMethod activationMethod) {
        this.activationMethod = activationMethod;
    }
}
