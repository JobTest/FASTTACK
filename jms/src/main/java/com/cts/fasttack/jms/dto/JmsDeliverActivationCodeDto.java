package com.cts.fasttack.jms.dto;

import java.util.Date;

/**
 * @author a.lipavets
 */
public class JmsDeliverActivationCodeDto {

    private String requestId;
    /**
     * Unique reference to the token to be designated when digitization is complete.
     */
    private String tokenUniqueReference;

    /**
     * Value linking pre-digitization messages generated during provisioning.
     */
    private String correlationId;

    /**
     * The Activation Code to be distributed for the digitization
     */
    private String activationCode;

    /**
     * The DateTime when the Activation Code is no longer valid
     */
    private Date expirationDateTime;

    /**
     * The activation method selected by the Cardholder
     */
    private String activationMethod;

    /** getters and setters */

    public String getTokenUniqueReference() {
        return tokenUniqueReference;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public String getActivationMethod() {
        return activationMethod;
    }

    public void setActivationMethod(String activationMethod) {
        this.activationMethod = activationMethod;
    }
}
