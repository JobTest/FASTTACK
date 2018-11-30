package com.cts.fasttack.core.dto;

/**
 * The Token information
 *
 * @author a.lipavets
 */
public class TokenDto {

    /**
     * The token issued for this service request
     */
    private String token;

    /**
     * The month of the expiration date
     */
    private String expiryMonth;

    /**
     * The year of the expiration date
     */
    private String expiryYear;

    /**
     * Sequence number of the Token
     */
    private String sequenceNumber;

    /* getters and setters */
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
